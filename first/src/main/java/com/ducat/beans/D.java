package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class D {

	
	private A a;
	
	public D()
	{
		System.out.println("D bean is instantiated.");
	}
	@Autowired
	public void setA(A a)
	{
		this.a=a;
		System.out.println("Reference of A is injected into D.");
	}
	
	public String toString()
	{
		return "It is D bean, it has "+a;
	}
}
