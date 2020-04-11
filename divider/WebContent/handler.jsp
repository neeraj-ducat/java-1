<%@ page isErrorPage="true" %>
<%
if(exception instanceof ArithmeticException)
{
%>
<h3>Second number must be non zero.</h3>
<%
} else
{
%>
<h3>Input must be numeric.</h3>
<%
}
%>
<hr/>
<%@ include file="index.html" %>
