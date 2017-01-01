<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>spring study board</title>
	<link type="text/css" href="/static/css/style.css" rel="stylesheet" />
</head>

<body>
    <div id="<element>jb-container</element>">
    	<div id="jb-header">
    		<a href = "/board/boardList">[게시판 리스트]</a>
    		<a href = "/board/boardWriteForm">[게시판 글쓰기]</a>
    	</div>
    	<div id="jb-content">
    	
    		<form name = "boardModifyForm" action = "/board/boardUpdate" method = "post">
				<p><input type ="hidden" name="boardId" value = "${board.boardId}" /></p>
			    <p>제목 : <input type = "text" name = "title" value = "${board.title}" /></p>
				<p>작성자 : <input type = "text" name = "writer" value = "${board.writer}" /></p>
				<p>내용 : <br /><textarea rows="10" cols="80" name = "description">${board.description}</textarea></p>
				<p><input type = "submit" value = "확인" />
			</form>
	
			<form name = "/boardDeleteForm"  action="/board/boardDelete" method = "post">
				<p><input type ="hidden" name="boardId" value = "${board.boardId}" /></p>
				<p><input type = "submit" value = "글삭제" /></p>
			</form>
			
    	</div>
    	
    	<div id="jb-footer">
    		jb-footer
    	</div>
    </div>
</body>
</html>
