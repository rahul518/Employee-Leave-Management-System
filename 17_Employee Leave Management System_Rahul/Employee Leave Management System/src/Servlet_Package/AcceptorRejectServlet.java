package Servlet_Package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean_Package.EmployeeBean;
import DAO_Package.EmployeeDAO;
import DAO_Package.ManagerDAO;

/**
 * Servlet implementation class AcceptorRejectServlet
 */
@WebServlet("/AcceptorRejectServlet")
public class AcceptorRejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcceptorRejectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		String option1 = request.getParameter("option");
		out.println(option1);
		ManagerDAO md = new ManagerDAO();
		EmployeeDAO ed = new EmployeeDAO();
		if(option1.equals("accept"))
		{
			EmployeeBean bean1 = new EmployeeBean();
			bean1 = (EmployeeBean) request.getSession().getAttribute("bean1");
			out.println("bean in servlet"+bean1);
			md.acceptLeave(bean1);
			request.getSession().removeAttribute("bean1");
		}

		else if(option1.equals("reject"))
		{
			EmployeeBean bean1 = new EmployeeBean();
			bean1 = (EmployeeBean) request.getSession().getAttribute("bean1");			
			out.println("bean in servlet"+bean1);
			md.rejectLeave(bean1);
			ed.updateleaves(bean1);
		}
		else {} 	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
