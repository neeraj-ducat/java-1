<%@page import="com.ducat.entities.User" %>
<%
User user=(User)session.getAttribute("user");
%>
<h3>Welcome <%= user.getName() %></h3>
<a href="profile">view profile</a> <br/>
<a href="logout">logout</a> <br/>
