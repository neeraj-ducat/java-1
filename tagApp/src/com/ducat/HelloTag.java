package com.ducat;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class HelloTag extends TagSupport {

	private String user;
	
	public void setUser(String user)
	{
		this.user=user;
	}
	
	public int doEndTag()
	{
		JspWriter out= pageContext.getOut();
		try
		{
			out.println("<h3>Welcome, "+user+"</h3>");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	return EVAL_PAGE;
	}
}
