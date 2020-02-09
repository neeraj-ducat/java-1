package com.ducat;

import java.sql.*;
import java.util.Scanner;

public class ProcedureTest {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.print("Enter EmpId: ");
		int id=in.nextInt();
		in.close();
		try
		{
		//Connection is obtained
		Connection con=ConnectionProvider.getConnection();
		//CallableStatement is created for the procedure
		CallableStatement stmt=con.prepareCall(
				"{call getName(?,?)}");
		//Value of IN parameter is set.
		stmt.setInt(1, id);
		//Type of value returned by out parameter is specified
		stmt.registerOutParameter(2, Types.VARCHAR);
		//Procedure is executed
		stmt.execute();
		//Value of out parameter is read
		String name=stmt.getString(2);
		if(name == null)
			System.out.println("Invalid Id.");
		else
			System.out.println("Name is: "+name);
		
		//connection is closed.
		con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
