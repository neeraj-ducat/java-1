package com.ducat;

import java.sql.*;
import java.util.Scanner;

public class TablesFinder {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Database Name: ");
		String db=in.nextLine();
		String pattern=null;
		System.out.print("Want to filter tables, yes/no?");
		String ans=in.nextLine();
		if(ans.equalsIgnoreCase("yes"))
		{
			System.out.print("Enter Name Pattern: ");
			pattern=in.nextLine();
		}
		in.close();
		try
		{
		Connection con	= ConnectionProvider.getConnection();
		//DatabaseMetaData object is obtained
		DatabaseMetaData dmd =con.getMetaData();
		//Tables info is fetched from the DatabaseMetaData
		ResultSet rset=dmd.getTables(db, null, pattern, 
				new String[] {"TABLE"});
		System.out.println("Following tables are found:");
		while(rset.next())
			System.out.println(rset.getString(3));
			
		con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
