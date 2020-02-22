package com.ducat;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class DemoServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException
	{
		//Value of request parameters is read.
		String format=request.getParameter("format");
		//Output stream is obtained to write response
		PrintWriter out=response.getWriter();
		//Content type of the response is set conditionally.
		if(format.equals("text"))
		response.setContentType("text/plain");
		else if(format.equals("html"))
			response.setContentType("text/html");
		else
		response.setContentType("application/msword");
		//Result is written to the response
		out.println("<h1>It is h1 heading.</h1>");
		out.println("<h2>It is h2 heading.</h2>");
		out.println("<h3>It is h3 heading.</h3>");
		out.println("<h4>It is h4 heading.</h4>");
		out.println("<h5>It is h5 heading.</h5>");
		//output stream is closed
		out.close();
	}
}
