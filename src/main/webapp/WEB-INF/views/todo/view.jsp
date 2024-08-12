<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할일 상세</title>
</head>
<body>
<c:choose>
	<c:when test="${not empty msg}">
	<div style="color:red;">${msg}</div>
	<div><a href="javascript:history.back();">뒤로가기</a></div>
	</c:when>
	<c:otherwise>
	<div>
		<span>번호:</span>
		<span>${todo.tNo}</span>
	</div>
	<div>
		<span>할일:</span>
		<span>${todo.title}</span>
	</div>
	<div>
		<span>작성자:</span>
		<span>${todo.writer}</span>
	</div>
	<div>
		<span>완료일:</span>
		<span>${todo.dueDate}</span>
	</div>
	<div>
		<span>완료여부:</span>
		<span>${todo.complete ? '완료' : '미완료'}</span>
	</div>
	<div>
		<a href="/todo/update?tNo=${todo.tNo}">수정</a>
		<a href="/todo/delete?tNo=${todo.tNo}">삭제</a>
	</div>
	</c:otherwise>
</c:choose>
</body>
</html>