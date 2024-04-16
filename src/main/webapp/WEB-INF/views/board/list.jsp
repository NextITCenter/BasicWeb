<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<table>
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일자</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="board" items="${boards}">
	<tr>
		<td>${board.no }</td>
		<td>${board.title }</td>
		<td>${board.writer }</td>
		<td>${board.createDate }</td>
		<td>${board.hits }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>