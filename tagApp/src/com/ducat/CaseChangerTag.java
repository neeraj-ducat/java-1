package com.ducat;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class CaseChangerTag extends BodyTagSupport {

	private String target;
	
	public void setTarget(String target)
	{
		this.target = target;
	}
	
	
	public int doEndTag()
	{
		JspWriter out= pageContext.getOut();
		String body= bodyContent.getString();
		try {
			if(target.equalsIgnoreCase("upper"))
				out.println(body.toUpperCase());
			else
				out.println(body.toLowerCase());
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return EVAL_PAGE;	
	}
}
