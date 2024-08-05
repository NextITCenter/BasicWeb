<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
</head>
<body>
<h3>내 정보 수정</h3>
<form action="/mypage" method="post">
	<div>
		<label>이름: 
			<input type="text">
		</label>
	</div>
	<div>
		<label>이메일:
			<input type="text">
		</label>
	</div>
	<div>
		<label>주소:
			<input type="text">
		</label>
	</div>
	<div>
		<button>수정</button>
		<button type="button">취소</button>
	</div>
</form>
</body>
</html>