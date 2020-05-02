package com.ducat.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class Conductor {

	@Lookup
	public abstract Ticket getTicket();
}
