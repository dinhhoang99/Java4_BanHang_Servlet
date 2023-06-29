package Servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import Bean.UserBean;
import Entity.UserEntity;
import Services.UserServices;
import Services.Impl.UserServicesImpl;
import constant.SessionAttr;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet({"/index/profile","/index/profile/update/*","/index/profile/delete/*"})
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "abc";
    UserServices userService = new UserServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
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
		if(uri.contains("update")) {
			request.setAttribute("title", "Update Thành Công");
			request.getRequestDispatcher("/views/user/profileuser.jsp").forward(request, response);
		}else {
			request.setAttribute("title", "Thông Tin Cá Nhân");
			request.getRequestDispatcher("/views/user/profileuser.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uri = request.getRequestURI();
		if (uri.contains("update")) {
			update(request, response);
		}else {
			delete(request, response);
			return;
		}
		doGet(request, response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getRequestURI();
		int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/")+1));
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		UserEntity user = userService.findById(id);
		UserEntity userEntity = new UserEntity();

		
		userEntity.setId(user.getId());
		userEntity.setFullname(fullname);
		userEntity.setUsername(username);
		userEntity.setPassword(password);
		userEntity.setEmail(email);
		userEntity.setImages(user.getImages());
		userEntity.setIsActive(user.getIsActive());
		userEntity.setIsAdmin(user.getIsAdmin());
		userService.update(userEntity);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/")+1));
		userService.delete(id);
		HttpSession session = request.getSession();
		session.removeAttribute(SessionAttr.CURRENT_USER);
		response.sendRedirect("/ASM_Java4/index");
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
