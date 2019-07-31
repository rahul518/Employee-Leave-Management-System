package Servlet_Package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean_Package.EmployeeBean;
import DAO_Package.CEODAO;
import DAO_Package.EmployeeDAO;
import DAO_Package.ManagerDAO;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		EmployeeDAO ed = new EmployeeDAO();
		EmployeeBean bean = new EmployeeBean();
		HttpSession session = request.getSession();
		ManagerDAO md = new ManagerDAO();
		CEODAO cd = new CEODAO();
		String option=request.getParameter("varname");
		System.out.println(option);

		if(option.equals("viewserv"))
		{
			bean.setUsername((String)session.getAttribute("username"));
			ResultSet rs = ed.viewleaves(bean);
			RequestDispatcher rd = request.getRequestDispatcher("view_leaves.jsp");
			request.setAttribute("rs",rs);
			rd.forward(request,response);
		}

		else if(option.equals("view"))
		{

			ResultSet rs=md.managerView();

			RequestDispatcher rd = request.getRequestDispatcher("view_leavesemp.jsp");
			request.setAttribute("rs",rs);
			rd.forward(request,response);
		}

		else if(option.equals("ceoview"))
		{
			ResultSet rs = cd.ceoview();
			session.setAttribute("rs", rs);
			RequestDispatcher rd = request.getRequestDispatcher("view_all.jsp");
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
