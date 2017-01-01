<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>spring study board</title>
	<link type="text/css" href="/static/css/style.css" rel="stylesheet" />
</head>

<body>
	<c:choose>
		<c:when test = "${login.isLogin == true}">
			${login.id} 님 환영합니다.
		</c:when>
		<c:otherwise>
 			<input type = "button" onclick = "" value = "로그인" />
 		</c:otherwise>
	</c:choose>
</body>
</html>