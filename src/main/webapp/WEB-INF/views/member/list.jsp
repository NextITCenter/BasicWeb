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
<!-- HTML 주석 -->
<%-- 자바 side 주석 --%>
<!-- EL(Expression Language) -->
<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>휴대전화번호</th>
		<th>이메일</th>
	</tr>
	<c:forEach items="${members}" var="m">
	<tr>
		<td>${m.memId}</td>
		<td>${m.memName}</td>
		<td>${m.memHp}</td>
		<td>${m.memMail}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>















