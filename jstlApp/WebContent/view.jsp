<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
<c:when test="${empList != null }">
<table border="1px; solid" style="width:100%;height:30%">
<tr><td>Name</td><td>Job</td><td>Salary</td></tr>
<c:forEach items="${empList}" var="emp">
<tr><td>${emp.name}</td><td>${emp.job}</td><td>${emp.salary}</td></tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h3>No Employee found.</h3>
</c:otherwise>
</c:choose>
<hr/>
<%@ include file="index.html" %>