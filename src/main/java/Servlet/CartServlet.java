package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
 * Servlet implementation class CartServlet
 */
@WebServlet({"/CartServlet","/user/cart/*"})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServices userServices = new UserServicesImpl();
    ProductServices productServices = new ProductServicesimpl();
    CartServices cartServices = new CartServicesImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		
		
		request.getRequestDispatcher("/views/user/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void addCart(HttpServletRequest request, HttpServletResponse response, String uri,HttpSession session) {
		
	}

}
