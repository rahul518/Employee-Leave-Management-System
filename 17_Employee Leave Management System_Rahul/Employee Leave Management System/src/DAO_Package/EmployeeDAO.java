package DAO_Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;

import Bean_Package.EmployeeBean;
import Connection_Package.ConnectionProvider;

public class EmployeeDAO {
	Connection con = ConnectionProvider.getCon();
	PreparedStatement ps;
	public int validate_leave(EmployeeBean bean)
	{
		try {
			ps = con.prepareStatement("select leavesleft from login where username=?");
			ps.setString(1,bean.getUsername());
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		}
		catch(Exception e)
		{}
		return 0;
	}
	public boolean validate_full_leave(EmployeeBean bean) {
		// TODO Auto-generated method stub

		try {
			ps = con.prepareStatement("select leavesleft from Login where username=?");
			ps.setString(1, bean.getUsername());
			ResultSet rs = ps.executeQuery();
			rs.next();
			if(rs.getInt(1)>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{}
		return false;
	}
	public int validate_full_leave_lop(EmployeeBean bean) {
		// TODO Auto-generated method stub
		try {
			ps = con.prepareStatement("update employeeleave set LOP=? where username=?");
			ps.setInt(1, bean.getDays_left());
			ps.setString(2, bean.getUsername());
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		}
		catch(Exception e) {}

		return 0;
	}
	public boolean insert_into_leave(EmployeeBean bean) {
		// TODO Auto-generated method stub
		try {
			ps = con.prepareStatement("insert into EmployeeLeave values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,bean.getStart());
			ps.setString(2, bean.getEnd());
			ps.setString(3,bean.getReason());
			ps.setInt(4,bean.getMonth());
			ps.setInt(6,bean.getDays_left());
			ps.setString(5, bean.getUsername());
			ps.setInt(7,bean.getLeaveid());
			ps.setString(8, "Pending");
			ps.setString(9, bean.getEmployeeType());
			ps.setInt(10, 3);
			ps.execute();

			ps = con.prepareStatement("update login set leavesleft=? where username=?");
			ps.setInt(1, bean.getDays_left());
			ps.setString(2,bean.getUsername());
			ps.execute();
			return true;
		}
		catch(Exception e)
		{}
		return false;
	}
	//public int calculateLOP(EmployeeBean bean) {
	// TODO Auto-generated method stub
	//try {
	//ps = con.prepareStatement("update login set LOP=? where username=?");
	//ps.setInt(1, bean.getDays_left());
	//ps.setString(2, bean.getUsername());
	//ResultSet rs = ps.executeQuery();
	//rs.next();
	//return rs.getInt(1);
	//}
	//catch(Exception e) {}
	//return 0;
	///}
	public int randomid() {
		// TODO Auto-generated method stub
		Random r = new Random();
		return r.nextInt(5000);
	}
	public void cancel_leave(EmployeeBean bean) {
		// TODO Auto-generated method stub
		try {
			ps = con.prepareStatement("delete from employeeleave where leaveid=?");
			ps.setInt(1,bean.getLeaveid());
			ps.execute();
		}
		catch(Exception e) {}

	}
	public ResultSet viewleaves(EmployeeBean bean) {
		// TODO Auto-generated method stub
		try {
			ps = con.prepareStatement("select * from employeeleave where username=?");
			ps.setString(1, bean.getUsername());
			ResultSet rs = ps.executeQuery();
			return rs;
		}
		catch(Exception e) {}
		return null;
	}
	public void updateleaves(EmployeeBean bean) {
		// TODO Auto-generated method stub
		try {
			ps = con.prepareStatement("select start,end,daysleft from employeeleave where leaveid=?");
			ps.setInt(1, bean.getLeaveid());
			ResultSet rs = ps.executeQuery();
			rs.next();
			LocalDate start = LocalDate.parse(rs.getString(1));
			LocalDate end = LocalDate.parse(rs.getString(2));
			int days = (int) ChronoUnit.DAYS.between(start, end)+1;
			int days_left = days + rs.getInt(3);
			ps = con.prepareStatement("update login set leavesleft=? where username=?");
			ps.setInt(1, days_left);
			ps.setString(2, bean.getUsername());
			ps.execute();
		}
		catch(Exception e)
		{}
	}
	public EmployeeBean getDetails(EmployeeBean bean) {
		// TODO Auto-generated method stub

		try {
			ps = con.prepareStatement("select * from employeeleave where leaveid=?");
			ps.setInt(1, bean.getLeaveid());
			ResultSet rs = ps.executeQuery();
			rs.next();

			EmployeeBean bean1 = new EmployeeBean();
			bean1.setStart(rs.getString(1));
			bean1.setEnd(rs.getString(2));
			bean1.setReason(rs.getString(3));
			bean1.setMonth(rs.getInt(4));
			bean1.setUsername(rs.getString(5));
			bean1.setDays_left(rs.getInt(6));
			bean1.setLeaveid(rs.getInt(7));
			bean1.setStatus(rs.getString(8));


			return bean1;
		}catch(Exception e) {}


		return null;
	}

	public int validate_leave_lop(EmployeeBean bean) {
		// TODO Auto-generated method stub
		try {
			ps = con.prepareStatement("select LOP from employeeleave where username=?");
			ps.setString(1,bean.getUsername());
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		}
		catch(Exception e) {}
		return 0;
	}

}
