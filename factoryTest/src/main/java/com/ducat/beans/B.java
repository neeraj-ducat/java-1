package com.ducat.beans;

//Assume that it is a library class and we don't have its source code but
//we need to get it instantiated by IOC Container.
public class B {

	public B()
	{
		System.out.println("B bean is created.");
	}
}
