<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>spring study sample</title>
</head>
<body>
<h1>
	sample list
</h1>


<table>
	<c:forEach items = "${sampleList}" var = "sample">
	<tr>
		<td>${sample.id}</td>
		<td>${sample.title}</td>
	</tr>
	</c:forEach>
</table>


</body>
</html>
