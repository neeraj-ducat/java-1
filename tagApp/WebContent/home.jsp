<%@ taglib uri="http://ducatindia/tags" prefix="ducat" %>

<%
String uname=request.getParameter("userName");
%>

<p>It is header </p>
<ducat:simple>
<p>It is body </p>
</ducat:simple>
<p>It is footer.</p>
<ducat:repeat iteration="2">
<ducat:hello user="<%=uname %>"/>
</ducat:repeat>