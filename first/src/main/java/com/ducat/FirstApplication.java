package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.*;

@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(FirstApplication.class, args);
		System.out.println("Requesting B bean...");
		B b=(B)ctx.getBean("b");
		System.out.println("Requesting C bean again...");
		C c=(C)ctx.getBean("c");
		System.out.println("Requesting D bean again...");
		D d=(D)ctx.getBean("d");
		System.out.println("printing B bean: "+b);
		System.out.println("printing C bean: "+c);
		System.out.println("printing D bean: "+d);
	}

}
