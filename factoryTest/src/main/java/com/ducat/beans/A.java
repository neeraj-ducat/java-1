package com.ducat.beans;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class A {
		
	public A()
	{
		System.out.println("A Bean is created.");
	}
	@PostConstruct
	public void init()
	{
		System.out.println("A is initialized.");
	}
}
