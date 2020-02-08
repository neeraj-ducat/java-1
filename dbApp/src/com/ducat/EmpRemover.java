package com.ducat;

import java.util.Scanner;

import com.ducat.dao.EmpDao;
import com.ducat.entities.Emp;

public class EmpRemover {

	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
		Scanner in =new Scanner(System.in);
		
		System.out.print("Enter Id: ");
		int id=in.nextInt();
		try
		{
		int deleted=dao.remove(id);
		if(deleted >0)
		System.out.println("successfully deleted.");
		else
		System.out.println("Invalid Id.");	
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
