package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.ABC;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		System.out.println("Requesting an ABC bean...");
		ABC abc = (ABC)ctx.getBean(ABC.class);
		System.out.println("Invoking a() method of ABC...");
		abc.a();
		System.out.println("Invoking b() method of ABC...");
		String value = abc.b();
		System.out.println(value+" is returned by b() in main().");
		System.out.println("Invoking c() method of ABC...");
		try {
		abc.c(5);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
