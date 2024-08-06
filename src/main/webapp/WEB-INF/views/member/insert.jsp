<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>
<!--
사용자가 서버에 데이터를 전송할 때
반드시 form 태그를 사용
1. input: 종류에 따라 text, password, radio, checkbox, file, hidden, submit, reset, image
			HTML5버전에서 추가된 종류 - tel, search, number, color, email, range, date
2. select: drop down list, combobox라고 하는 선택할 수 있는 태그 
3. textarea: 여러 줄의 문자를 입력받을 때 사용하는 태그
4. button: 입력이 아닌 동작에 해당하는 태그
주의: 반드시 name 속성이 존재해야 서버로 데이터가 전달된다.
 -->
<form action="/member/insert" method="post">
	<div>
		<label>아이디:
			<input type="text" name="memId">
		</label>
	</div>
	<div>
		<label>패스워드:
			<input type="password" name="memPass">
		</label>
	</div>
	<div>
		<label>이름:
			<input type="text" name="memName">
		</label>
	</div>
	<div>
		<label>생년월일:
			<input type="date" name="memBir">
		</label>
	</div>
	<div>
		<label>휴대전화번호:
			<input type="tel" name="memHp">
		</label>
	</div>
	<div>
		<label>이메일:
			<input type="email" name="memMail">
		</label>
	</div>
	<div>
		<button type="submit">등록</button>
	</div>
</form>
</body>
</html>