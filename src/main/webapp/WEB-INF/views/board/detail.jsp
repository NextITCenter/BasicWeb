<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 데스크탑 화면과 모바일 화면을 비슷한 비율로 처리하기 위한 코드 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- 이곳에 스타일시트 -->
<link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<div class="form-floating mb-3">
		<input type="text" name="id" id="boardId" value="${board.id}" class="form-control">
		<label for="boardId">게시글 아이디:</label>
	</div>
	<div class="form-floating mb-3">
		<input type="text" name="title" id="boardTitle" value="${board.title}" class="form-control">
		<label for="boardTitle">제목:</label>
	</div>
	<div class="form-floating mb-3">
		<input type="text" name="writer" id="boardWriter" value="${board.writer}" class="form-control">
		<label for="boardWriter">작성자:</label>
	</div>
	<div class="form-floating mb-3">
		<textarea style="height: 100px" name="content" id="boardContent" class="form-control">${board.content}</textarea>
		<label for="boardContent">내용:</label>
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
		<a href="/boards/modify?id=${board.id}" class="btn btn-primary">수정</a>
		<a href="/boards/remove?id=${board.id}" class="btn btn-success">삭제</a>
	</div>
	<div>
		<h4>Comments</h4>
	</div>
	<div>
		<form action="/comment/new" method="post">
			<div class="input-group">
				<div class="form-floating">
					<textarea style="height: 80px" name="content" id="content" class="form-control"></textarea>
					<label for="content">댓글</label>
				</div>
				<span>
					<button style="height: 80px" type="button" id="registerBtn" class="btn btn-info">등록</button>
				</span>
			</div>
			<input type="hidden" name="boardId" id="boardId" value="${board.id}">
			<input type="hidden" name="writer" id="writer" value="${sessionScope.member.memId }">
		</form>
	</div>
	<div id="commentList" class="list-group mb-3">
		<c:forEach items="${board.commentList}" var="comment">
		<div class="list-group-item list-group-item-action">
		    <div class="d-flex w-100 justify-content-between">
		      <h5 class="mb-1">${comment.content}</h5>
		      <small>${comment.registerDate}</small>
		    </div>
		    <p class="mb-1">${comment.writer}</p>
		    <small></small>
		    <div class="d-flex justify-content-end ${comment.writer eq sessionScope.member.memId ?'':'d-none'}">
		    	<button name="commentUpdateBtn" class="btn btn-outline-warning btn-sm">수정</button>
		    	<button name="commentDeleteBtn" class="btn btn-outline-danger btn-sm">삭제</button>
		    </div>
		</div>
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
			commentList.innerHTML += `<div class="list-group-item list-group-item-action">
		    <div class="d-flex w-100 justify-content-between">
		      <h5 class="mb-1">\${data.content }</h5>
		      <small>\${data.registerDate }</small>
		    </div>
		    <p class="mb-1">\${data.writer }</p>
		    <small></small>
			</div>`
			
			document.querySelector("#content").value = "";
		})
	})
	// 댓글 수정 및 삭제
	const commentUpdateBtns = document.querySelectorAll("[name=commentUpdateBtn]");
	const commentDeleteBtns = document.querySelectorAll("[name=commentDeleteBtn]");
	commentUpdateBtns.forEach(item => {
		item.addEventListener("click", (ev) => {
			console.log(ev.target.parentElement.parentElement);
			const parent = ev.target.parentElement.parentElement
			let content = parent.children[0].children[0].textContent
			parent.innerHTML = `<div class="input-group">
									<div class="form-floating">
										<textarea style="height: 80px" name="content" id="content" class="form-control">\${content}</textarea>
										<label for="content">댓글</label>
									</div>
									<span>
										<button style="height: 80px" type="button" id="registerBtn" class="btn btn-info">등록</button>
									</span>
									<span>
										<button style="height: 80px" type="button" id="cancelBtn" class="btn btn-secondary">취소</button>
									</span>
								</div>`;
		})
	});
</script>
</body>
</html>










