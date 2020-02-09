package com.ducat;

import java.io.InputStream;
import java.sql.*;
import java.util.StringTokenizer;



public class DbInitializer {

	public static void main(String[] args) {
		System.out.println("Initializing database...");
		try
		{
		//InputStream is created for db.sql
		InputStream in = DbInitializer.class.getResourceAsStream("db.sql");
		//A byte array equal to file size is created
		byte b[]= new byte[in.available()];
		//All the file data is read in the array
		in.read(b);
		//stream is closed
		in.close();
		//For the array, a String object is created
		String queries=new String(b);
		//A StringTokenizer object is created to extract 
		// individual queries
		StringTokenizer str=
				new StringTokenizer(queries, "$$");
		//Connection & statement objects are created.
		Connection con=ConnectionProvider.getConnection();
		Statement stmt=con.createStatement();
		while(str.hasMoreTokens())
		{
			//Queries are extracted and executed.
			stmt.execute(str.nextToken());
		}
		//connection is closed.
		con.close();
		System.out.println("Successfully initialized.");
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
