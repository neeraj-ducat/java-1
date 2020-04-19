<%@ page import="java.util.*" %>
<jsp:useBean id="emp" class="com.ducat.beans.Emp" />
<jsp:setProperty  name="emp" property="*"/>
<jsp:useBean id="empList" class="java.util.ArrayList" scope="application"/>
<%
empList.add(emp);
%>
<h3>Successfully added.</h3>
<%@ include file="index.html" %>