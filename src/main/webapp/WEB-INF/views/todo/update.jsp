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
	<c:when test="${not empty msg}">
	<div style="color:red;">${msg}</div>
	<div><a href="javascript:history.back();">뒤로가기</a></div>
	</c:when>
	<c:otherwise>
	<form action="/todo/update" method="post">
		<div>
			<label>번호:
				<input type="text" name="tNo" value="${todo.tNo}" readonly>
			</label>
		</div>
		<div>
			<label>할일:
				<input type="text" name="title" value="${todo.title}">
			</label>
		</div>
		<div>
			<label>작성자:
				<input type="text" name="writer" value="${todo.writer}">
			</label>
		</div>
		<div>
			<label>완료일자:
				<input type="date" name="dueDate" value="${todo.dueDate}">
			</label>
		</div>
		<div>
			<button>수정</button>
		</div>
	</form>
	</c:otherwise>
</c:choose>
</body>
</html>