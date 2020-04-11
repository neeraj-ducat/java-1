package com.ducat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("*.jsp")
public class HeaderFooterFilter implements Filter {

	//data member to store the reference of FilterConfig
	private FilterConfig config;
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;

	}

	@Override
	public void doFilter(ServletRequest request,
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// pre-processing 
		PrintWriter out=response.getWriter();
		out.println("<h3>Header will be displayed here.</h3><hr/>");
		// invoke the next component
		chain.doFilter(request, response);
		// post-processing
		out.println("<hr/><h3>Fotter will be displayed here.</h3>");
		out.close();
		
	}

	
	
	@Override
	public void destroy() {
		

	}

}
