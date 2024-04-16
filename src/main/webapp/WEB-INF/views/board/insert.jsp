<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<style>
	label {
		display: block;
	}
</style>
</head>
<body>
<form action="/board/insert" method="post">
	<label>제목:
		<input type="text" name="title">
	</label>
	<label>내용:
		<textarea rows="10" cols="40" name="content"></textarea>
	</label>
	<input type="hidden" name="writer" value="${member.id }">
	<div style="color:red;">${msg}</div>
	<button type="submit">등록</button>
	<button type="button">취소</button>
</form>
</body>
</html>