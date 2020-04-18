package com.ducat;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SimpleTag extends TagSupport {

	
	public int doStartTag()
	{
		JspWriter out= pageContext.getOut();
		try
		{
			out.println("<h3>It is generated from doStartTag()</h3>");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag()
	{
		JspWriter out= pageContext.getOut();
		try
		{
			out.println("<h3>It is generated from doEndTag()</h3>");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return EVAL_PAGE;
	}
}
