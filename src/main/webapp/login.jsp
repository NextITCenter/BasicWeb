<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h2>로그인</h2>
<form action="/login" method="post">
	<div>
		<label>
			<input type="text" placeholder="아이디">
		</label>
	</div>
	<div>
		<label>
			<input type="password" placeholder="패스워드">
		</label>
	</div>
	<div>
		<button>로그인</button>
		<button type="button">취소</button>
	</div>
</form>
</body>
</html>