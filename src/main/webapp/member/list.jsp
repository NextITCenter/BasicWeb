<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style>
	form {
		text-align: right;
		padding-right: 100px;
	}
</style>
</head>
<body>
<header>
<c:choose>
	<c:when test="${not empty member}"><!-- member != null, member ne null -->
		<form action="/logout" method="get">
			<span id="loginName">${member.name }님</span>
			<button type="submit">로그아웃</button>
		</form>
	</c:when>
	<c:otherwise>
		<form action="/login" method="get">
			<button type="submit">로그인</button>
		</form>
	</c:otherwise>
</c:choose>
</header>
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




