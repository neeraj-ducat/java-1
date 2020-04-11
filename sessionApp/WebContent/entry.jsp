<%
String name=request.getParameter("name");
session.setAttribute("name", name);
%>
<h3>Welcome, <%=name %></h3>
<a href=exit.jsp>exit</a>