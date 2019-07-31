package Servlet_Package;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean_Package.EmployeeBean;
import Bean_Package.LoginBean;
import DAO_Package.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			LoginDAO dao = new LoginDAO();
			LoginBean bean = new LoginBean();
			EmployeeBean beane = new EmployeeBean();
			bean.setUsername(request.getParameter("username"));
			bean.setPassword(request.getParameter("password"));
			ResultSet rs = dao.validate(bean);
			rs.next();

			HttpSession session = request.getSession();
			session.setAttribute("username", bean.getUsername());
			session.setAttribute("EmployeeType", rs.getString(1));

			if(rs!=null)
			{
				if(rs.getString(1).equals("Employee"))
					response.sendRedirect("employee.jsp");

				else if(rs.getString(1).equals("Manager"))
					response.sendRedirect("manager.jsp");

				else if(rs.getString(1).equals("CEO"))
					response.sendRedirect("CEO.jsp");
			}
		}
		catch(Exception e)
		{}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
