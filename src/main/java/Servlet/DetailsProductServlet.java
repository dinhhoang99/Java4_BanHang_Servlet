package Servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.CartEntity;
import Entity.ProductEntity;
import Entity.UserEntity;
import Services.CartServices;
import Services.ProductServices;
import Services.UserServices;
import Services.Impl.CartServicesImpl;
import Services.Impl.ProductServicesimpl;
import Services.Impl.UserServicesImpl;
import constant.SessionAttr;

/**
 * Servlet implementation class DetailsProductServlet
 */
@WebServlet({"/DetailsProductServlet/*"})
public class DetailsProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserServices userServices = new UserServicesImpl();
    ProductServices productServices = new ProductServicesimpl();
    CartServices cartServices = new CartServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsProductServlet() {
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
		HttpSession session = request.getSession();
		int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/") + 1));
		ProductEntity productDetails = productServices.findById(id);
		UserEntity user = (UserEntity) session.getAttribute(SessionAttr.CURRENT_USER);
		List<ProductEntity> listAll = productServices.findAll();
		if(user == null) {
			response.sendRedirect("/ASM_Java4/login");
			return;
		}else {
				productDetails.setView(productDetails.getView() + 1);
				
				List<ProductEntity> listProduct = productServices.findAllPaging(1, 4);
				productServices.update(productDetails);
				history(request, response, uri);
				
				request.setAttribute("listProduct", listProduct);
				request.setAttribute("productDetails", productDetails);
				request.getRequestDispatcher("/views/user/detailsproduct.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String uri = request.getRequestURI();
//		System.out.println(uri);
		if(uri.contains("DetailsProductServlet")) {
			sendEmail(request, response, uri);
			return;
		}else if(uri.contains("cart")) {
			
		}
		
	}
	
	private void sendEmail(HttpServletRequest request, HttpServletResponse response, String uri) throws ServletException, IOException {
		int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/") + 1));
		String url = request.getRequestURL().toString();
		String email = request.getParameter("emailRecipent");
		String conten = request.getParameter("conten");
		String senderEmail = "dinhvhoang0903@gmail.com";
	    String senderPassword = "cjfssffpadvtpdmf";
	    
	    ProductEntity product = productServices.findById(id);
	    product.setShare(product.getShare() + 1);
	    
	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.ssl.protocols", "TLSv1.2");
	    props.put("mail.smtp.ssl.ciphers", "TLS_AES_128_GCM_SHA256");
	    
	    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	          return new javax.mail.PasswordAuthentication(senderEmail, senderPassword);
	        }
	      });
	    
	    try {
	    	response.setContentType("text/html;charset=UTF-8");
	        // Tạo đối tượng MimeMessage để đại diện cho email
	        Message emailMime = new MimeMessage(session);
	        emailMime.setFrom(new InternetAddress(senderEmail));
	        emailMime.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
	        emailMime.setSubject("Sản Phẩm Được Chia Sẻ : " + conten);
	        emailMime.setText(url);
	        
	        // Gửi email
	        Transport.send(emailMime);
	        //Update Share
	        productServices.update(product);
	        // Trả về phản hồi cho người dùng
	        System.out.println("Thành Công");
//	        
	      } catch (MessagingException e) {
	    	  System.out.println("Thất Bại");
	        throw new RuntimeException(e);
	      }
	    doGet(request, response);
	}

	
	@SuppressWarnings("unchecked")
	private void history(HttpServletRequest request, HttpServletResponse response, String uri) {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/") + 1));
		List<ProductEntity> productList = (List<ProductEntity>) session.getAttribute(SessionAttr.CURRENT_PRODUCT);

		if(productList == null) {
			productList = new ArrayList<ProductEntity>();
		}
		 ProductEntity product = productServices.findById(id);
		 productList.add(product);
		 session.setAttribute(SessionAttr.CURRENT_PRODUCT, productList);
		  int i =1;
		 for(ProductEntity pr : productList) {
			 System.out.println(pr.getTitle());
			 System.out.println(i++);
		 }
	}
}
