package com.ducat;

import java.sql.*;
import java.util.Scanner;

public class TransactionTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter source A/C No. ");
		int src=in.nextInt();
		System.out.print("Enter target A/C No. ");
		int target=in.nextInt();
		System.out.print("Enter amount to be transferred ");
		int amount=in.nextInt();
		in.close();
		Connection con=null;
		try
		{
			con=ConnectionProvider.getConnection();
			//Auto commit is disabled
			con.setAutoCommit(false);
			PreparedStatement stmt=con.prepareStatement(
					"select balance from Account where acno=?");
		    PreparedStatement stmt1=
		    	con.prepareStatement(
		    	"update Account set balance=balance-? where acno=?");
		    PreparedStatement stmt2=
			    	con.prepareStatement(
			    "update Account set balance=balance+? where acno=?");
		    // checking the balance of the source a/c
		    stmt.setInt(1, src);
		    ResultSet rset=stmt.executeQuery();
		    if(rset.next())
		    {
		    	int balance=rset.getInt(1);
		    	if(balance >= amount)
		    	{
		    		//deducting the amount from the source A/C
		    		stmt1.setInt(1, amount);
		    		stmt1.setInt(2, src);
		    		stmt1.executeUpdate();
		    		//adding the amount to the target A/C
		    		stmt2.setInt(1, amount);
		    		stmt2.setInt(2, target);
		    		int updated=stmt2.executeUpdate();
		    		if(updated==0)
		    			throw(new Exception("Invalid target A/C"));
		    	}
		    	else
		    	{
		    		throw(new Exception("Insufficient balance in source A/C"));
		    	}
		    }
		    else
		    {
		    	throw(new Exception("Invalid source A/C"));
		    }
		   //Queries are explicitly committed
		    con.commit();
		    System.out.println("Successfully transferred.");
		    
			
		}catch(Exception e)
		{
			System.out.println("Transaction failed: "+e.getMessage());
			System.out.println("Rolling back...");
			try
			{
				con.rollback();
				System.out.println("successfully rolled back.");
			}catch(Exception ex)
			{
				System.out.println("Can't be rolled back "+ex);
			}
		}
		finally
		{
			try {
			con.close();
			}catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
	}

}
