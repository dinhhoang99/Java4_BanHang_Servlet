package Servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

import Bean.ProductBean;
import Dao.AbstractDao;
import Entity.ProductEntity;
import Services.ProductServices;
import Services.UserServices;
import Services.Impl.ProductServicesimpl;
import Services.Impl.UserServicesImpl;

/**
 * Servlet implementation class ProductAdminServlet
 */
@WebServlet({"/admin/product","/admin/product/add","/admin/product/delete/*","/admin/product/addProduct","/admin/product/edit/*","/admin/product/EditProduct/*"})
@MultipartConfig()
public class ProductAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "abc";
	ProductServices services = new ProductServicesimpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		List<ProductEntity> list = services.findAll();
		if(uri.contains("add")) {
			request.getRequestDispatcher("/views/admin/addproduct.jsp").forward(request, response);
		}else {
			request.setAttribute("listProduct", list);
			request.setAttribute("titleProduct", "Product");
			request.getRequestDispatcher("/views/admin/product.jsp").forward(request, response);
		}
	}

	private void getList(HttpServletRequest request,  HttpServletResponse response)throws ServletException, IOException{
		List<ProductEntity> list = services.findAll();
		request.setAttribute("listProduct", list);
		request.getRequestDispatcher("/views/admin/product.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("addProduct")) {
			request.setAttribute("submit", "product/add");
			request.getRequestDispatcher("/views/admin/addproduct.jsp").forward(request, response);
			return;
		}else if(uri.contains("add")){
			addProduct(request, response);
			return;
		}else if(uri.contains("edit")){
			int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/")+1));
			ProductEntity prFindById = services.findById(id);
			request.setAttribute("listProdutById", prFindById);
			request.setAttribute("submit", "product/EditProduct/" + prFindById.getId() );
			request.getRequestDispatcher("/views/admin/addproduct.jsp").forward(request, response);
			return;
		}else if(uri.contains("EditProduct")){
			editProduct(request, response);
		}else if(uri.contains("delete")){
			deleteProduct(request, response);
		}else if(uri.contains("product")){
			request.getRequestDispatcher("/views/admin/addproduct.jsp").forward(request, response);
			return;
		}
		
		doGet(request, response);
	}
	
	
	
	private ProductEntity getData(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ProductEntity prEntity = new ProductEntity();
		ProductBean prBean = new ProductBean();
		
		String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        Part photoPart = request.getPart("photo");
        String photoName = getSubmittedFileName(photoPart);
        String photoPath = UPLOAD_DIRECTORY + File.separator + photoName;
        photoPart.write(uploadPath + File.separator + photoName);
        
		try {
			BeanUtils.populate(prBean, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Lấy Giá Trị Thời Gian Khi Ấn nút thêm sản phẩm
		Timestamp dateSubmit = new Timestamp(System.currentTimeMillis());
		prEntity.setTitle(prBean.getProductName());
		prEntity.setPrice(prBean.getPrice());
		prEntity.setCategory(prBean.getCategory());
		prEntity.setQuantity(prBean.getQuantity());
		prEntity.setPoster(photoPath);
		prEntity.setDescribe(prBean.getDescription());
		prEntity.setIsActive(prBean.getActive());
		prEntity.setDate_submitted(dateSubmit);
		
		
		return prEntity;
	}
	private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/")+1));
		ProductEntity prFindById = services.findById(id);
		
		ProductBean prBean = new ProductBean();
		
		String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        System.out.println(prFindById.getTitle() + "Đinh Văn Hoàng");
        Part photoPart = request.getPart("photo");
        String photoName = getSubmittedFileName(photoPart);
        String photoPath = UPLOAD_DIRECTORY + File.separator + photoName;
        
		try {
			BeanUtils.populate(prBean, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newPhotoPath = photoPath.substring(4);
		
		prFindById.setId(id);
		prFindById.setTitle(prBean.getProductName());
		prFindById.setPrice(prBean.getPrice());
		prFindById.setCategory(prBean.getCategory());
		prFindById.setQuantity(prBean.getQuantity());
		prFindById.setView(prFindById.getView());
		prFindById.setShare(prFindById.getShare());
		prFindById.setSold(prFindById.getSold());
		if(newPhotoPath == "") {
			prFindById.setPoster(prFindById.getPoster());
			System.out.println(prFindById.getPoster());
		}else {
			prFindById.setPoster(photoPath);
			photoPart.write(uploadPath + File.separator + photoName);
		}
		prFindById.setDescribe(prBean.getDescription());
		prFindById.setIsActive(prBean.getActive());
		services.update(prFindById);	
		request.setAttribute("titleProduct", "Update Product Success");
	}
	
	
	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		services.create(getData(request, response));
		request.setAttribute("titleProduct", "Add Product Success");
	}
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI();
		int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/")+1));
		request.setAttribute("titleProduct", "Delete Product Success");
		services.delete(id);
	}
	private String getSubmittedFileName(Part part) {
        String header = part.getHeader("content-disposition");
        String[] tokens = header.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
}
