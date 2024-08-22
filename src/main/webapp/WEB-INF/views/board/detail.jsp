<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 이곳에 스타일시트 -->
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
		첨부파일:
		<div>
		<c:forEach items="${board.fileList}" var="file">
			<a href="/file/download?id=${file.id}">${file.originalName}</a>
		</c:forEach>
		</div>
	</div>
	<div>
		<a href="/boards/modify?id=${board.id}">수정</a>
		<a href="/boards/remove?id=${board.id}">삭제</a>
	</div>
	<div>
		<h4>Comments</h4>
	</div>
	<div>
		<form action="/comment/new" method="post">
			<textarea rows="4" cols="30" name="content" id="content"></textarea>
			<input type="hidden" name="boardId" id="boardId" value="${board.id}">
			<input type="hidden" name="writer" id="writer" value="miso">
			<button type="button" id="registerBtn">등록</button>
		</form>
	</div>
	<div id="commentList">
		<c:forEach items="${board.commentList}" var="comment">
		<div>${comment.content}</div>
		</c:forEach>
	</div>
</div>
<!-- 자바스크립트 위치 -->
<script>
	// fetch() 함수를 이용해서 서버로 댓글 전송(post 방식으로 전송)
	// 결과를 방금 등록한 댓글만 응답받게 한다.
	const registerBtn = document.querySelector("#registerBtn");
	// 아래 코드보다 좀더 간편하게 폼 데이터를 전송하는 방식
	/*
		FormData 객체가 존재 => 보통 첨부파일이 존재할 때 간단하게 데이터 전송할 수 있음
		multipart/form-data로 전송됨
	*/
	registerBtn.addEventListener("click", (e) => {
		// fectch보다 사용하기 편한 axios 라이브러리 사용
		fetch("/comment/new", {
			method: "POST",
			headers: {
				"Content-Type": "application/x-www-form-urlencoded"
			},
			// "Content-Type": "application/json"
			// "Content-Type": "multipart/form-data" => 첨부파일 처리하는 설정 필요
			// Content-Type을 생략하면 기본적으로 text/plain;charset=UTF-8로 전송한다.
			body: `boardId=\${document.querySelector("#boardId").value}&content=\${document.querySelector("#content").value}&writer=\${document.querySelector("#writer").value}`
		})
		.then(response => response.json())
		.then(data => {
			const commentList = document.querySelector("#commentList")
			commentList.innerHTML += `<div>\${data.content}</div>`;
			document.querySelector("#content").value = "";
		})
	})
	
</script>
</body>
</html>










