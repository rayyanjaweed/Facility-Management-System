package com.fms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	/**
	 * 
	 * @return returns the connection status.
	 */
	public static Connection getSqlConnection () {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FMSDatabase?" + "user=root&password=tiger");
		} catch (SQLException e) {
			System.out.println("SQLException");
		} catch (ClassNotFoundException e) {
			System.out.println("SQLException");
		}
		return conn;
	}

}
