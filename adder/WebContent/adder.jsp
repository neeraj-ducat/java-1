<%!
public void jspInit()
{
System.out.println("adder.jsp is initialized.");	
}
%>

<%
int a = 
Integer.parseInt(request.getParameter("num1"));
int b = 
Integer.parseInt(request.getParameter("num2"));
int c=a+b;
%>
<h3>Sum is: <%=c %> </h3>
<hr/>
<jsp:include page="index.html"/>