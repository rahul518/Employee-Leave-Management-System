package Servlet_Package;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean_Package.EmployeeBean;
import DAO_Package.CEODAO;
import DAO_Package.EmployeeDAO;
import java.time.temporal.ChronoUnit;
/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/mm/yyyy");
		PrintWriter out = response.getWriter();
		String start_date = request.getParameter("start");
		String end_date = request.getParameter("end");
		LocalDate start = LocalDate.parse(start_date);
		LocalDate end = LocalDate.parse(end_date);

		HttpSession session = request.getSession();

		EmployeeDAO dao = new EmployeeDAO();
		EmployeeBean bean = new EmployeeBean();
		bean.setUsername((String)session.getAttribute("username"));
		bean.setEmployeeType((String) session.getAttribute("EmployeeType"));
		bean.setStart(start_date);
		bean.setEnd(end_date);
		bean.setMonth(Integer.parseInt(request.getParameter("month")));
		bean.setReason(request.getParameter("reason"));
		bean.setLeaveid(dao.randomid());

		if(request.getParameter("varname").equals("apply"))
		{
			int days_left = dao.validate_leave(bean);
			out.println(ChronoUnit.DAYS.between(start, end)+1);
			int days = (int) ChronoUnit.DAYS.between(start, end) + 1;
			bean.setDays_left(dao.validate_leave(bean)-days);
			if(days <= 5)
			{

				if(days <= days_left)
				{				


					if(dao.validate_full_leave(bean))
					{

						if(dao.insert_into_leave(bean))
						{

							out.println("Applied Sucessfully");
							out.println("Leaves Left:"+bean.getDays_left());
						}

					}
				}
				else
				{
					response.setContentType("text/html");
					out.println("This is going to count under loss of pay.Do you agree?<br>");
					out.println("<a href=\"applylop.jsp\"><input type=\"button\" name=\"lop\" value=\"Agree\"></a><br>");
					out.println("<a href=\"apply.jsp\"><input type=\"button\" name=\"no\" value=\"Back\"></a>");
				}
			}
		}
		else if(request.getParameter("varname").equals("applylop"))
		{

			int days_left = dao.validate_leave_lop(bean);
			out.println(ChronoUnit.DAYS.between(start, end)+1);
			int days = (int) ChronoUnit.DAYS.between(start, end) + 1;
			bean.setDays_left(dao.validate_leave_lop(bean)-days);
			if(days <= 3)
			{

				if(days <= days_left)
				{				

					int val = dao.validate_full_leave_lop(bean);
					if(val>=0 && val<=3)
					{
						if(dao.insert_into_leave(bean))
						{
							out.println("Applied Sucessfully");
							out.println("Leaves Left:"+bean.getDays_left());
						}

					}

				}

			}
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
