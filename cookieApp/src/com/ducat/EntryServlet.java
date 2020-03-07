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
		//A cookie is created for the name
		Cookie ck=new Cookie("user",name);
		//Making the cookie persistent for a day
		ck.setMaxAge(60*60*24);
		//cookie is added to the response
		response.addCookie(ck);
		//content type of response is set
		response.setContentType("text/html");
		//output stream is obtained
		PrintWriter out=response.getWriter();
		//response is generated
		out.println("<h3>Welcome, "+name+"</h3>");
		out.println("<a href=exitServlet>exit</a>");
		//output stream is closed
		out.close();
	 }
}
