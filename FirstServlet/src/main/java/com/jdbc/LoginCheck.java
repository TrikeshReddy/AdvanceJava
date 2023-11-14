package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginCheck {
	public static boolean checkCredentials(String uname,String pwd) {
		try {
			Class.forName("com.cj.mysql.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql:localhost/","root","root@12");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
}
