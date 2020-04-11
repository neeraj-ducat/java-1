<%
String name=(String)session.getAttribute("name");
session.invalidate();
%>
<h3><%=name %>, You have successfully exited.</h3>
<a href=index.html>try again</a>