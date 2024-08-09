<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할일 목록</title>
</head>
<body>
<table>
	<tr>
		<th>번호</th>
		<th>할일</th>
		<th>작성자</th>
		<th>완료여부</th>
		<th>마감일자</th>
	</tr>
	<!-- 
		for (TodoVO todo : todoList) {
			todo.getTNo();
		}
	 -->
	<c:forEach var="todo" items="${todoList}">
	<tr>
		<td>${todo.tNo}</td>
		<td><a href="/todo/view?tNo=${todo.tNo}">${todo.title}</a></td>
		<td>${todo.writer}</td>
		<td>${todo.complete ? '완료' : '미완료'}</td>
		<td>${todo.dueDate}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>