package Servlet_Package;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean_Package.EmployeeBean;
import DAO_Package.EmployeeDAO;

/**
 * Servlet implementation class AcceptorReject
 */
@WebServlet("/AcceptorReject")
public class AcceptorReject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcceptorReject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		PrintWriter out = response.getWriter();
		int leaveid=0;
		if(request.getParameter("name1")!=null)
			leaveid =Integer.parseInt(request.getParameter("name1"));
		EmployeeBean bean = new EmployeeBean();
		bean.setLeaveid(leaveid);

		request.setAttribute("leaveid", leaveid);

		EmployeeBean bean1=new EmployeeBean();
		EmployeeDAO dao = new EmployeeDAO();
		bean1 = dao.getDetails(bean);

		request.setAttribute("bean",bean1);
		if(request.getParameter("varname").equals("manager"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
			rd.forward(request, response);
		}
		else if(request.getParameter("varname").equals("ceo"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("view_particular.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
