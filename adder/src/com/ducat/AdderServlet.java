package com.ducat;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class AdderServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException
	{
		//Value of request parameters is read.
		int a = 
		Integer.parseInt(request.getParameter("num1"));
		int b = 
		Integer.parseInt(request.getParameter("num2"));
		//Processing is done
		int c=a+b;
		//Output stream is obtained to write response
		PrintWriter out=response.getWriter();
		//Content type of the response is set.
		response.setContentType("text/html");
		//Result is written to the response
		out.println("<h3>Sum is: "+c+"</h3>");
		//output stream is closed
		out.close();
	}
}
