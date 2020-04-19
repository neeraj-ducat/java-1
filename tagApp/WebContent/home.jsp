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

<ducat:changeCase target="upper">
<p>it was written in lower case.</p>
</ducat:changeCase>

<ducat:changeCase target="lower">
<p>IT WAS WRITTEN IN UPPER CASE.</p>
</ducat:changeCase>