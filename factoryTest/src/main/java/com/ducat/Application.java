package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.B;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		System.out.println("Requesting two B instances...");
		B b1=(B)ctx.getBean(B.class);
		B b2=(B)ctx.getBean(B.class);
	}

}
