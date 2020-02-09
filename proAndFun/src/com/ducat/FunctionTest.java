package com.ducat;

import java.sql.*;
import java.util.Scanner;

public class FunctionTest {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.print("Enter EmpId: ");
		int id=in.nextInt();
		in.close();
		try
		{
		//Connection is obtained
		Connection con=ConnectionProvider.getConnection();
		//CallableStatement is created for the function
		CallableStatement stmt=con.prepareCall(
				"{? = call getSalary(?)}");
		//Value of IN parameter is set.
		stmt.setInt(2, id);
		//Type of value returned by out parameter is specified
		stmt.registerOutParameter(1, Types.INTEGER);
		//Procedure is executed
		stmt.execute();
		//Value of out parameter is read
		int sal=stmt.getInt(1);
		if(sal == 0)
			System.out.println("Invalid Id.");
		else
			System.out.println("Salary is: "+sal);
		
		//connection is closed.
		con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
