package Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Bean.LoginBean;
import Bean.UserBean;
import Entity.UserEntity;
import Services.UserServices;
import Services.Impl.UserServicesImpl;

/**
 * Servlet implementation class UserAdminServlet
 */
@WebServlet({"/admin/user","/admin/user/edit/*","/admin/user/confirm/*","/admin/user/delete/*"})
public class UserAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserServices userServices = new UserServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAdminServlet() {
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
			
			List<UserEntity> list = userServices.findAll();
			request.setAttribute("listUser", list);
			if(uri.contains("confirm")) {
				request.setAttribute("message", "Update Success");
			}else if(uri.contains("delete")){
				request.setAttribute("message", "Delete Success");
			}else {
				request.setAttribute("message", "User Account");
			}
			
			request.getRequestDispatcher("/views/admin/userstatic.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String uri = request.getRequestURI();
		
		if(uri.contains("edit")) {
			int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/")+1));
			UserEntity user = userServices.findById(id);
			request.setAttribute("listUser", user);
			request.setAttribute("submit", "user/confirm/" + user.getId());
			request.getRequestDispatcher("/views/admin/adduser.jsp").forward(request, response);
			return;
		}else if(uri.contains("confirm")) {
			int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/")+1));
			UserBean userBean = new UserBean();
			UserEntity user = userServices.findById(id);
//			LoginBean lg = new LoginBean();
			UserEntity userEntity = new UserEntity();
			try {
				BeanUtils.populate(userBean, request.getParameterMap());
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			userEntity.setId(user.getId());
			userEntity.setFullname(userBean.getFullname());
			userEntity.setUsername(userBean.getUsername());
			userEntity.setPassword(userBean.getPassword());
			userEntity.setEmail(userBean.getEmail());
			userEntity.setImages(user.getImages());
			userEntity.setIsActive(userBean.getIsActive());
			userEntity.setIsAdmin(userBean.getIsAdmin());
			userServices.update(userEntity);
		}else {
			int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/")+1));
			userServices.delete(id);
		}
		
		doGet(request, response);
		
	}

}
