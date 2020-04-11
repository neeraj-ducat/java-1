<%@ page errorPage="/handler.jsp" %>
<%
int a = 
Integer.parseInt(request.getParameter("num1"));
int b = 
Integer.parseInt(request.getParameter("num2"));
int c=a/b;
%>
<h3>Result is: <%=c %> </h3>
<hr/>
<%@ include file="index.html" %>
