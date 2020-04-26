package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class C {

	
	private A a;
	
	public C()
	{
		System.out.println("C bean is instantiated.");
	}
	@Autowired
	public C(A a)
	{
		this.a=a;
		System.out.println("C bean is instantiated and reference of A is injected into it.");
	}
	
	public String toString()
	{
		return "It is C bean, it has "+a;
	}
}
