package com.ducat;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	public static Connection getConnection() throws Exception
	{
		// Driver class is loaded to get it registered
		Class.forName("com.mysql.jdbc.Driver");
		// Connection object is created
		Connection con= DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/userdb",
				"root","");
		return con;
	}
}
