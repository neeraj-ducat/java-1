package com.ducat;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class EntryServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
	 throws ServletException, IOException
	 {
		//Request data is read
		String name=request.getParameter("name");
		//content type of response is set
		response.setContentType("text/html");
		//output stream is obtained
		PrintWriter out=response.getWriter();
		//response is generated
		out.println("<h3>Welcome, "+name+"</h3>");
		//username is appended to the url of hyperlink
		//as parameter
		
		out.println(
		"<a href=\"exitServlet?user="
		+name+"\">exit</a>");
		
		//output stream is closed
		out.close();
	 }
}
