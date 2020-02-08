package com.ducat;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ducat.dao.EmpDao;
import com.ducat.entities.Emp;

public class EmpLoaderById {

	public static void main(String[] args) {
		EmpDao dao=new EmpDao();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter EmpId: ");
		int id=in.nextInt();
		try
		{
		Emp e=dao.getById(id);
		
		if(e !=null)
			System.out.println(e);
		else
			System.out.println("Invalid Id.");
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
