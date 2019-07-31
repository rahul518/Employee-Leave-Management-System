package DAO_Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean_Package.EmployeeBean;
import Connection_Package.ConnectionProvider;

public class ManagerDAO {

	Connection con = ConnectionProvider.getCon();
	PreparedStatement ps;
	ResultSet rs;
	public ResultSet managerView()
	{
		try {
			ps = con.prepareStatement("select * from employeeleave where employeetype=? and status=?");
			ps.setString(1,"Employee");
			ps.setString(2, "Pending");
			ResultSet rs = ps.executeQuery();

			return rs;
		}
		catch(Exception e)
		{}
		return null;
	}

	public void rejectLeave(EmployeeBean bean1) {
		// TODO Auto-generated method stub
		try {

			ps = con.prepareStatement("update employeeleave set status=? where leaveid=?");
			ps.setString(1, "Rejected");
			ps.setInt(2, bean1.getLeaveid());
			ps.execute();
		}catch(Exception e) {}
	}
	public void acceptLeave(EmployeeBean bean1) {
		// TODO Auto-generated method stub
		try {		
			ps = con.prepareStatement("update employeeleave set status=? where leaveid=?");
			ps.setString(1, "Accepted");
			ps.setInt(2, bean1.getLeaveid());
			ps.execute();
		}catch(Exception e) {}
	}

}
