<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할일 상세</title>
</head>
<body>
<div>
	<span>번호:</span>
	<span>${todo.tNo}</span>
</div>
<div>
	<span>할일:</span>
	<span>${todo.title}</span>
</div>
<div>
	<span>작성자:</span>
	<span>${todo.writer}</span>
</div>
<div>
	<span>마감일:</span>
	<span>${todo.dueDate}</span>
</div>
<div>
	<span>완료여부:</span>
	<span>${todo.complete ? '완료' : '미완료'}</span>
</div>
</body>
</html>