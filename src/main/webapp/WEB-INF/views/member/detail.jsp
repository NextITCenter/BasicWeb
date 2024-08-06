<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
</head>
<body>
<h3>${member.memName}님 정보</h3>
<div>아이디: ${member.memId }</div>
<div>생년월일: ${member.memBir }</div>
<div>우편번호: ${member.memZip }</div>
<div>주소: ${member.memAdd1 }</div>
<div>상세주소: ${member.memAdd2 }</div>
<div>휴대전화: ${member.memHp }</div>
<div>이메일: ${member.memMail }</div>
<div>
	<a href="/member/update?id=${member.memId}">수정</a>
	<a href="/member/delete?id=${member.memId}">삭제</a>
</div>
</body>
</html>