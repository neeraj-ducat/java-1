package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy

public class B {

	@Autowired
	private A a;
	
	public B()
	{
		System.out.println("B bean is instantiated.");
	}
	
	public String toString()
	{
		return "It is B bean, it has "+a;
	}
}
