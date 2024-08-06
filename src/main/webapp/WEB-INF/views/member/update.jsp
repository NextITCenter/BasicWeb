<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
</head>
<body>
<form action="/member/update" method="post">
	<div>
		<label>아이디:
			<input type="text" name="memId" value="${member.memId}" readonly="readonly">
	</label>
	</div>
	<div>
		<label>이름:
			<input type="text" name="memName" value="${member.memName }">
		</label>
	</div>
	<div>
		<label>생년월일:
			<input type="date" name="memBir" value="${member.memBir }">
		</label>
	</div>
	<div>
		<label>휴대전화번호:
			<input type="tel" name="memHp" value="${member.memHp }">
		</label>
	</div>
	<div>
		<label>이메일:
			<input type="email" name="memMail" value="${member.memMail }">
		</label>
	</div>
	<div>
		<button type="submit">수정</button>
	</div>
</form>
</body>
</html>