package Servlet;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.StatisticalServices;
import Services.Impl.StatisticalServicesImpl;

/**
 * Servlet implementation class IndexAdminServlet
 */
@WebServlet("/admin")
public class IndexAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       StatisticalServices services = new StatisticalServicesImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		Long countProduct = services.countProduct();
		Long countUser = services.countUser();
		Long countBill = services.countBill();
		Long revenue = services.revenue();
		String revenueNew = formatter.format(revenue);
		request.setAttribute("countProduct", countProduct);
		request.setAttribute("countUser", countUser);
		request.setAttribute("countBill", countBill);
		request.setAttribute("revenue", revenueNew + "VND");
		request.getRequestDispatcher("views/admin/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		doGet(request, response);
	}

}
