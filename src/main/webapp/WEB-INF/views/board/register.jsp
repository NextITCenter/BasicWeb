<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
<form action="/boards/register" method="post" enctype="multipart/form-data">
	<div>
		<label>제목:
			<input type="text" name="title">
		</label>
	</div>
	<div>
		<label>작성자:
			<input type="text" name="writer" value="${sessionScope.member.memId}">
		</label>
	</div>
	<div>
		<label>내용:
			<textarea rows="4" cols="30" name="content"></textarea>
		</label>
	</div>
	<div>
		<label>첨부파일:
			<input type="file" name="files">
		</label>
	</div>
	<div>
		<button>등록</button>
	</div>
</form>
</body>
</html>