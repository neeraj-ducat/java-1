package com.ducat;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;

@WebServlet("/servlets/entryServlet")
public class EntryServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
	 throws ServletException, IOException
	 {
		//Request data is read
		String name=request.getParameter("name");
		//HttpSession object of the current user is
		//obtained
		HttpSession session=request.getSession();
		//user name is stored as attribute in the session
		session.setAttribute("name", name);
		//content type of response is set
		response.setContentType("text/html");
		//output stream is obtained
		PrintWriter out=response.getWriter();
		//response is generated
		out.println("<h3>Welcome, "+name+"</h3>");
		out.println("<a href=exitServlet>exit</a>");
		
	 }
}
