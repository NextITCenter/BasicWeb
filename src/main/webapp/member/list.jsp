<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
<!-- HTML 주석 -->
<%-- 자바 side 주석 --%>
${members } <!-- EL(Expression Language) -->
<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>휴대전화번호</th>
		<th>이메일</th>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
</table>
</body>
</html>















