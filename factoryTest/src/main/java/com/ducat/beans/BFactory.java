package com.ducat.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BFactory {

	@Bean
	@Scope("prototype")
	public B getB() // Factory method for Bean B.
	{
		System.out.println("Factory Method of B is invoked.");
		return new B();
	}
}
