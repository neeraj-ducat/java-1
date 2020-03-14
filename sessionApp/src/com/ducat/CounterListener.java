package com.ducat;

import javax.servlet.*;
import javax.servlet.http.*;

public class CounterListener implements 
	ServletContextListener, HttpSessionListener {

	private ServletContext ctx;
	
	@Override
	public void contextInitialized(
			ServletContextEvent e) {
		// Reference of ServletContext is obtained from the event object
		ctx = e.getServletContext();
		//total & current counters are set in the context
		ctx.setAttribute("total", 0);
		ctx.setAttribute("current", 0);

	}
	@Override
	public void sessionCreated(HttpSessionEvent e) {
	// Both the counters are fetched, incremented and reset
	Integer t = (Integer)ctx.getAttribute("total");
	t++;
	ctx.setAttribute("total", t);
	Integer c = (Integer)ctx.getAttribute("current");
	c++;
	ctx.setAttribute("current", c);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {
	// Current counter is fetched, decremented and reset
		Integer c = (Integer)ctx.getAttribute("current");
		c--;
		ctx.setAttribute("current", c);
	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
	}

	

}
