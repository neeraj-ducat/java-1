package com.ducat;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;
@WebServlet("/servlets/adminServlet")
public class AdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
	 throws ServletException, IOException
	 {
		//Reference of ServletContext is obtained
		ServletContext ctx = getServletConfig().getServletContext();
		//content type of response is set
		response.setContentType("text/html");
		//output stream is obtained
		PrintWriter out=response.getWriter();
		//Counter are fetched from the context and
		//written to the output stream as response.
		out.println("<h3>Welcome Admin, counters are:</h3>");
		Integer c = (Integer)ctx.getAttribute("current");
		Integer t = (Integer)ctx.getAttribute("total");
		out.println("<h4>Total users: "+t+"</h4>");
		out.println("<h4>Current users: "+c+"</h4>");
		out.println("<a href=adminServlet>refresh</a>");
		
	 }
}
