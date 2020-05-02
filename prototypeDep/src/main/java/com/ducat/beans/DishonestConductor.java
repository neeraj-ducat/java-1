package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class DishonestConductor extends Conductor {

	@Autowired
	private Ticket ticket;
	
	@Override
	public Ticket getTicket() {
		
		return ticket;
	}

}
