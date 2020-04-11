<%@ page session="false" %>
<h3>Welcome Admin, counters are:</h3>
<%
Integer c = (Integer)application.getAttribute("current");
Integer t = (Integer)application.getAttribute("total");
%>
<h4>Total users: <%=t %></h4>
Current users: <%=c %></h4>
<a href=admin.jsp>refresh</a>