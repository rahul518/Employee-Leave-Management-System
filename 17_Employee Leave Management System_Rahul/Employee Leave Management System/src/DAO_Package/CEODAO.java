package DAO_Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Bean_Package.EmployeeBean;
import Connection_Package.ConnectionProvider;

public class CEODAO {
	Connection con = ConnectionProvider.getCon();
	PreparedStatement ps;
	public ResultSet ceoview() {
		// TODO Auto-generated method stub
		try {
			ps = con.prepareStatement("select * from employeeleave where employeetype=? and Status=?");
			ps.setString(1, "Manager");
			ps.setString(2, "Pending");
			return ps.executeQuery();
		}
		catch(Exception e) {}
		return null;
	}



}
