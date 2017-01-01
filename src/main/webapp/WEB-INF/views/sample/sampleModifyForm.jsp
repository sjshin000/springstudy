<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>spring study sample</title>
</head>
<body>
<h1>
	sample modify form
</h1>

<form name = "sampleModifyForm" action = "/sample/sampleUpdate" method = "post">
<table>
	<tr>
		<td>id</td>
		<td><input type = "text" name = "id" value = "${sample.id}" /></td>
	</tr>
	<tr>
		<td>title</td>
		<td><input type = "text" name = "title" value = "${sample.title }" /></td>
	</tr>
</table>
<input type = "submit" value = "수정"/>
</form>


<form name = "sampleDelete" action = "/sample/sampleDelete" method = "post">
<input type = "hidden" name = "id" value = "${sample.id}" />
<input type = "submit" value = "삭제"/>
</form>

</body>
</html>
