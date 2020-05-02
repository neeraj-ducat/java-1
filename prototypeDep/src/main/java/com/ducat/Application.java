package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.Conductor;
import com.ducat.beans.Ticket;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		System.out.println("Requesting conductor bean...");
		//Conductor con=(Conductor)ctx.getBean("dishonestConductor");
		//Conductor con=(Conductor)ctx.getBean("honestConductor");
		Conductor con=(Conductor)ctx.getBean("conductor");
		System.out.println("Class of Conductor object is: "+con.getClass().getName());
		System.out.println("Requesting two tickets from the conductor...");
		Ticket t1= con.getTicket();
		Ticket t2= con.getTicket();
		System.out.println("Details of first ticket: "+t1);
		System.out.println("Details of second ticket: "+t2);
	}

}
