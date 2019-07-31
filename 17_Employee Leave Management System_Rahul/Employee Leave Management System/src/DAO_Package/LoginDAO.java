package DAO_Package;

import java.sql.*;

import Bean_Package.LoginBean;
import Connection_Package.ConnectionProvider;

public class LoginDAO {

	Connection con = ConnectionProvider.getCon();
	PreparedStatement ps;
	public ResultSet validate(LoginBean bean)
	{
		try {

			ps = con.prepareStatement("select employeetype from login where username=? and password=?");
			ps.setString(1,bean.getUsername());
			ps.setString(2, bean.getPassword());
			ResultSet rs = ps.executeQuery();
			return rs;
		}
		catch(Exception e)
		{}
		return null;
	}
}
