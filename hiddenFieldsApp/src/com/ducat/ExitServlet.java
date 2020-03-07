package com.ducat;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ExitServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
	 throws ServletException, IOException
	 {
		//value of user request parameter is read
		String name=request.getParameter("user");
		//content type of response is set
		response.setContentType("text/html");
		//output stream is obtained
		PrintWriter out=response.getWriter();
		//response is generated
		out.println("<h3>"+name+", you have successfully exited.</h3>");
		out.println("<a href=index.html>try again</a>");
		//output stream is closed
		out.close();
	 }
}
