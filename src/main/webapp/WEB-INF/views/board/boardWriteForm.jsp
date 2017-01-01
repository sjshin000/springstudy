<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>spring study board</title>
	<link type="text/css" href="/static/css/style.css" rel="stylesheet" />
</head>

<body>
	<div id="jb-header">
		<a href = "/board/boardList">[게시판 리스트]</a>
		<a href = "/board/boardWriteForm">[게시판 글쓰기]</a>
	</div>
	
	<div id="jb-content">
    	
    	<form name = "boardWriteForm" action="/board/boardInsert" method = "post">
			<p>제목 : <input type = "text" name = "title" /></p>
			<p>작성자 : <input type = "text" name = "writer" /></p>
			<p>내용 : <br /><textarea rows="10" cols="80" name = "description"></textarea></p>
			<p><input type = "submit" value = "확인" />
		</form>
		
    </div>
    	
   	<div id="jb-footer">
   		jb-footer
   	</div>
</body>
</html>