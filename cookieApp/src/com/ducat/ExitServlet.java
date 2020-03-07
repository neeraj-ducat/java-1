package com.ducat;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ExitServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
	 throws ServletException, IOException
	 {
		//Var to store userName
		String name="Guest";
		//Cookies are obtained from the request object
		Cookie ck[]=request.getCookies();
		//if a cookie is received, its value is read
		if(ck != null)
			name=ck[0].getValue(); //We have sent only cookie in 
		//the previous servlet hence this array would have at
		//most one memeber
		
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
