package com.ducat;

import javax.servlet.jsp.tagext.TagSupport;

public class RepeaterTag extends TagSupport {

	private int iteration;
	
	public void setIteration(String itr)
	{
		this.iteration = Integer.parseInt(itr);
	}
	
	public int doStartTag()
	{
		return EVAL_BODY_INCLUDE;
	}
	public int doAfterBody()
	{
		iteration--;
		if(iteration > 0)
		return EVAL_BODY_AGAIN;
		else
		return SKIP_BODY;	
	}
}
