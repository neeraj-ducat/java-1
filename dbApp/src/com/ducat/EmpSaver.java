package com.ducat;

import java.util.Scanner;

import com.ducat.dao.EmpDao;
import com.ducat.entities.Emp;

public class EmpSaver {

	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
		Emp emp=new Emp();
		Scanner in =new Scanner(System.in);
		
		System.out.print("Enter Name: ");
		emp.setName(in.nextLine());
		
		System.out.print("Enter Job: ");
		emp.setJob(in.nextLine());
		
		System.out.print("Enter Salary: ");
		emp.setSalary(in.nextInt());
		try
		{
		dao.save(emp);
		System.out.println("successfully saved.");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
