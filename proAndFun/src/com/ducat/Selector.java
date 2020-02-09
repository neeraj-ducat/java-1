package com.ducat;

import java.sql.*;
import java.util.Scanner;

public class Selector {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Table Name: ");
		String table=in.nextLine();
		in.close();
		String query="select * from "+table;
		try
		{
		//Connection is obtained
		Connection con=ConnectionProvider.getConnection();
		//Statement is created 
		Statement stmt=con.createStatement();
		//Query is executed
		ResultSet rset=stmt.executeQuery(query);
		//ResultSetMetaData is obtained
		ResultSetMetaData rmd=rset.getMetaData();
		//No. of selected columns is obtained
		int count=rmd.getColumnCount();
		//Column names are printed as header
		System.out.println("=====================================");
		for(int i=1;i <=count;i++)
			System.out.print(rmd.getColumnName(i)+"\t");
		
		System.out.println();
		System.out.println("=====================================");
		//Values of selected records are printed.
		while(rset.next())
		{
			for(int i=1;i <=count;i++)
				System.out.print(rset.getString(i)+"\t");
			
			System.out.println();
		}
		//connection is closed.
		con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
