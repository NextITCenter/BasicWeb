<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To Do 등록</title>
</head>
<body>
<!--
 url: get			view?tNo=1에서 tNo가 파라미터
 form: get, post	name 속성의 값이 파라미터 이름
 참고:
 요청할 때 parameter와 attribute를 사용해서 데이터를 전달한다.
 parameter: 사용자가 보내는 데이터 => getParameter() (O), setParameter() (X)
 		setParameter()가 없는 대신에 <input type="hidden" name="" value="">을 사용한다.
 attribute: 개발자가 보내는 데이터 => getAttribute() (O), setAttribute() (O)
 
 -->
<div style="color: red">${msg}</div>
<form action="/todo/insert" method="post">
	<div>할일: 
		<input type="text" name="title">
	</div>
	<div>작성자: 
		<input type="text" name="writer">
	</div>
	<div>완료일자:
		<input type="date" name="dueDate">
	</div>
	<div>
		<button>등록</button>
	</div>
</form>
</body>
</html>