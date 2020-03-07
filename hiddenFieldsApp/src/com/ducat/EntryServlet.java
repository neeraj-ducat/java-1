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
		//A form containing hidden text field is
		//generated
		out.println("<form action=exitServlet method=get>");
		out.println(
		"<input type=hidden name=user value=\""
		+name+"\">");
		out.println("<input type=submit value=exit>");
		out.println("</form>");
		//output stream is closed
		out.close();
	 }
}
