<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>spring study sample</title>
</head>
<body>
<h1>
	sample wirte form
</h1>

<form name = "sampleWriteForm" action = "/sample/sampleInsert" method = "post">
<table>
	<tr>
		<td>id</td>
		<td><input type = "text" name = "id"/></td>
	</tr>
	<tr>
		<td>title</td>
		<td><input type = "text" name = "title"/></td>
	</tr>
</table>
<input type = "submit" />
</form>
</body>
</html>
