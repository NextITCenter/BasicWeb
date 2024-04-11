<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
<h1>회원 목록</h1>
<a href="/member/add">신규 회원</a>
<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>가입일자</th>
	</tr>
	<c:forEach var="member" items="${members}">
	<tr>
		<td><a href="/member/view?id=${member.id}">${member.id}</a></td>
		<td><a href="/member/view?id=${member.id}">${member.name}</a></td>
		<td>${member.email}</td>
		<td>${member.createDate}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>




