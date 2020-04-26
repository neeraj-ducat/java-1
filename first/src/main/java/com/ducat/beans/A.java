package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope("prototype")
public class A {

	private static int counter;
	private int no;
		
	public A()
	{
		no=++counter;
		System.out.println("Bean "+no+" of A is instantiated.");
	}
	
	public String toString()
	{
		return "Bean "+no+" of A";
	}
}
