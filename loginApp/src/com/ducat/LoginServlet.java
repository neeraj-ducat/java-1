package com.ducat;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;


public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
		{
		//Value of request parameters is read.
		String m= 
		request.getParameter("mailId");
		String p = 
		request.getParameter("password");
		try
		{
		//Output stream is obtained to write response
		PrintWriter out=response.getWriter();
		//Content type of the response is set.
		response.setContentType("text/html");
		//Reference of the ServletConfig object is obtained from the servlet
		ServletConfig config= getServletConfig();
		//Reference of ServletContext is obtained from the config
		ServletContext ctx=config.getServletContext();
		//Using the init params of context connection is created
		Class.forName(ctx.getInitParameter("driverClass"));
		Connection con=DriverManager.getConnection(
				ctx.getInitParameter("url"),
				ctx.getInitParameter("user"),
				ctx.getInitParameter("password"));
		//Statement is created
		PreparedStatement stmt=con.prepareStatement(
			"select * from UsersMaster where mailId=? and password=?");
		//Parameter values are set in the statement 
		stmt.setString(1, m);
		stmt.setString(2, p);
		//Query is executed
		ResultSet rset=stmt.executeQuery();
		if(rset.next())
		{
			//user is valid, it's name is fetched to generate the response
			out.println("<h3>Welcome, "+rset.getString(2)+"</h3>");
		}
		else
		{
		// Error message is generated
		out.println("<h3>Invalid mailId or Password.</h3><hr/>");
		//contents of index.html get included
		RequestDispatcher rd=
				request.getRequestDispatcher("index.html");
		rd.include(request, response);
		}
		//output stream and connection are closed
		out.close();
		con.close();
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
