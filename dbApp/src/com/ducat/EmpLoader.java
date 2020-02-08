package com.ducat;

import java.util.Iterator;
import java.util.List;

import com.ducat.dao.EmpDao;
import com.ducat.entities.Emp;

public class EmpLoader {

	public static void main(String[] args) {
		EmpDao dao=new EmpDao();
		try
		{
		List<Emp> list=dao.getAllEmp();
		Iterator<Emp> itr=list.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
