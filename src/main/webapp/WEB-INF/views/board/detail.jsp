<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<div>
		<label>게시글 아이디:
			<input type="text" name="id" value="${board.id}">
		</label>
	</div>
	<div>
		<label>제목:
			<input type="text" name="title" value="${board.title}">
		</label>
	</div>
	<div>
		<label>작성자:
			<input type="text" name="writer" value="${board.writer}">
		</label>
	</div>
	<div>
		<label>내용:
			<textarea rows="4" cols="30" name="content">${board.content}</textarea>
		</label>
	</div>
	<div>
		<a href="/boards/modify?id=${board.id}">수정</a>
		<a href="/boards/remove?id=${board.id}">삭제</a>
	</div>
</div>
</body>
</html>