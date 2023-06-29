	package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Dao.Impl.UserDaoImpl;
import Entity.ProductEntity;
import Entity.UserEntity;
import Services.ProductServices;
import Services.UserServices;
import Services.Impl.ProductServicesimpl;
import Services.Impl.UserServicesImpl;
import constant.SessionAttr;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet({"/index","/index/page/*","/user/search"})
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int PRODUCT_MAX_PAGE_SIZE = 4;
       ProductServices productServices = new ProductServicesimpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
	UserServices user = new UserServicesImpl();
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uri = request.getRequestURI();
		List<ProductEntity> listProduct;
		List<ProductEntity> listAll = productServices.findAll();
		int maxPage = (int) Math.ceil(listAll.size() / (double) PRODUCT_MAX_PAGE_SIZE);
		int minPage = 1;
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity) session.getAttribute(SessionAttr.CURRENT_USER);
		if(uri.contains("page")) {
			int numberPage = Integer.parseInt(uri.substring(uri.lastIndexOf("/")+1));
			listProduct = productServices.findAllPaging(numberPage, PRODUCT_MAX_PAGE_SIZE);
			minPage = numberPage;
			request.setAttribute("currenPages", numberPage);
			if(uri.contains("DetailsProductServlet")) {
				if(user == null) {
					response.sendRedirect("/ASM_Java4/login");
					return;
				}
			}
		}else {
			listProduct = productServices.findAllPaging(1, PRODUCT_MAX_PAGE_SIZE);
			request.setAttribute("currenPages", 1);
		}
		
		
		request.setAttribute("listProduct", listProduct);
		request.setAttribute("minPage", minPage);
		request.setAttribute("maxPage", maxPage);
		request.getRequestDispatcher("/views/user/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		String searchProduct = request.getParameter("searchProduct");
//		System.out.println(searchProduct);
		List<ProductEntity> listSearch = productServices.searchProduct(searchProduct);
		request.setAttribute("listProduct", listSearch);
		request.getRequestDispatcher("/views/user/searchproduct.jsp").forward(request, response);
	}

}
