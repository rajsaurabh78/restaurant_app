package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	public static Connection provideConnection() {
		
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/restaurent";
		try {
			conn=DriverManager.getConnection(url,"root","Common@78");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}

}
