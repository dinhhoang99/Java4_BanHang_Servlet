package Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import Bean.LoginBean;
import Bean.SiginBean;
import Entity.UserEntity;
import Services.UserServices;
import Services.Impl.UserServicesImpl;
import Utils.CookieUtils;
import constant.SessionAttr;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({"/login","/register","/logout"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private UserServices userServices = new UserServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		if(uri.contains("login")) {
			request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
		}else if(uri.contains("logout")) {
			logout(request, response);
		}else {
			request.getRequestDispatcher("views/user/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String uri = request.getRequestURI();
		if(uri.contains("login")) {
			login(request, response);
		}else {
			register(request, response);
		}
		
	}
	
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		SiginBean sigin = new SiginBean();
		
		HttpSession session = request.getSession();
		try {
			BeanUtils.populate(sigin, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserEntity userCheck = userServices.findByUserNameAndEmail(sigin.getUserNameSignIn(), sigin.getEmailSignIn());
		if(userCheck == null){
			UserEntity user = userServices.create(sigin.getNameSignIn(), sigin.getUserNameSignIn(), sigin.getPassWordSignIn(), sigin.getEmailSignIn());
		}else {
			request.setAttribute("siginError", "UserName Hoặc Email Đã Tồn Tại");
		}
		request.getRequestDispatcher("views/user/login.jsp").forward(request, response);
		
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginBean lg = new LoginBean();
		HttpSession session = request.getSession();
		try {
			BeanUtils.populate(lg, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserEntity user = userServices.login(lg.getUserName(), lg.getPassWord());
		UserEntity email = userServices.loginByEmailAndPassword(lg.getUserName(), lg.getPassWord());
		if(user == null) {
			if(email == null) {
				request.setAttribute("error", "UserName Hoặc PassWord Chưa Đúng");
				request.getRequestDispatcher("views/user/login.jsp").forward(request, response);
			}else {
				session.setAttribute(SessionAttr.CURRENT_USER, user);
				if(email.getIsAdmin() == true) {
					cookie(request, response);
					response.sendRedirect("admin");
				}else {
					cookie(request, response);
					response.sendRedirect("index");
				}
			}
		}else {
			session.setAttribute(SessionAttr.CURRENT_USER, user);
			if (user.getIsAdmin() == true) {
				cookie(request, response);
				response.sendRedirect("admin");
			}else {
				cookie(request, response);
				response.sendRedirect("index");
			}
		}
	}
	
	private void cookie(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		String remember = request.getParameter("remember");
		
		int hours = (remember == null) ? 0 : 30*24; // 0 = xóa
		CookieUtils.add("username", username, hours, response);
		CookieUtils.add("password", password, hours, response);
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute(SessionAttr.CURRENT_USER);
		session.removeAttribute(SessionAttr.CURRENT_PRODUCT);
		response.sendRedirect("index");
	}

}
