<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${not empty member}">
	<div>
		${sessionScope.member.memName}님이 로그인하셨습니다.
		<a href="/logout?id=${sessionScope.member.memId}">로그아웃</a>
	</div>
	</c:when>
	<c:otherwise>
	<div>
		<a href="/login">로그인</a>
	</div>
	</c:otherwise>
</c:choose>
<a href="/boards/register">게시글 등록</a>
<table>
	<tr>
		<th>게시글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일자</th>
		<th>조회수</th>
	</tr>
	<c:forEach items="${boards}" var="board">
	<tr>
		<td>${board.id}</td>
		<td><a href="/boards/detail?id=${board.id}">${board.title}</a></td>
		<td>${board.writer}</td>
		<td>${board.registerDate}</td>
		<td>${board.hits}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>