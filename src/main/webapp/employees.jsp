<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees</title>
</head>
<body>
<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>고용일자</th>
	</tr>
	<!-- EL(Expression Language) 표현 언어 p.250에 설명되어 있음 -->
	<c:forEach var="vo" items="${employees }">
	<tr>
		<td>${vo.employeeId }</td>
		<td>${vo.empName }</td>
		<td>${vo.email }</td>
		<td>${vo.phoneNumber }</td>
		<td>${vo.hireDate }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>











