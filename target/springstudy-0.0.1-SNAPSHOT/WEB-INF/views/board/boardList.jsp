<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>spring study board</title>
	<link type="text/css" href="/static/css/style.css" rel="stylesheet" />
</head>

<body>
    <div id="<element>jb-container</element>">
    	<div id="jb-header">
<%--    		<%@ include file= "/login/loginCheck" %>
 --%>
    		<a href = "/board/boardList">[게시판 리스트]</a>
    		<a href = "/board/boardWriteForm">[게시판 글쓰기]</a>
    		<a href = "/login/loginForm">[로그인]</a>
    	</div>
    	<br id="jb-content">

			<table>
				<tr class = 'title'>
					<th width = 50>순서</th>
					<th width = 50>id</th>
					<th width = 300>제목</th>
					<th width = 50>작성자</th>
					<th width = 100>작성일</th>
					<th width = 100>수정일</th>
					<th width = 50>조회수</th>
				</tr>
				<c:set var="totalCount"  value = "${fn:length(boardList)}"/>
				<c:forEach items = "${boardList}" var = "board" varStatus="status">
				<tr>
					<td>${totalCount-status.index}</td>
					<td>${board.boardId}</td>
					<td><a href = "/board/boardModifyForm?boardId=${board.boardId}">${board.title}</a></td>
					<td><c:out value = "${board.writer}" /></td>
					<td><fmt:formatDate value="${board.creatDate}" type="both" /></td>
					<td><fmt:formatDate value="${board.updateDate}" type="both" /></td>
					<td>${board.hit}</td>
				</tr>

				</c:forEach>
			</table>
        
	    </div>
    	<div id="jb-footer">
			</br>
			총 건수는 : "${pageNavigationModel.totalRecodeCount}", 총 페이지 갯수는 "${pageNavigationModel.totalPageCount}"
			</br>
			<c:forEach var="i" begin="1" end="${pageNavigationModel.totalPageCount}" step="1">
				<%--<c:out value="${i}" />--%>
				<a href = "/board/boardList?page=${i}">[${i}]</a>
			</c:forEach>
    	</div>
    </div>
</body>
</html>
