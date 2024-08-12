<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할일 목록</title>
<style>
	.tr-line-through {
		text-decoration: line-through;
	}
	.tr-none {
		text-decoration: none;
	}
</style>
</head>
<body>
<a href="/todo/insert">할일 등록</a>
<table>
	<tr>
		<th>번호</th>
		<th>할일</th>
		<th>작성자</th>
		<th>완료여부</th>
		<th>완료일자</th>
		<th>완료</th>
	</tr>
	<!-- 
		for (TodoVO todo : todoList) {
			todo.getTNo();
		}
	 -->
	<c:forEach var="todo" items="${todoList}">
	<tr>
		<td>${todo.tNo}</td>
		<td><a href="/todo/view?tNo=${todo.tNo}">${todo.title}</a></td>
		<td>${todo.writer}</td>
		<td>${todo.complete ? '완료' : '미완료'}</td>
		<td>${todo.dueDate}</td>
		<td><input type="checkbox" id="${todo.tNo}" ${todo.complete?'checked':''}></td>
	</tr>
	</c:forEach>
</table>
<script>
	
	document.querySelectorAll("input[type=checkbox]").forEach(item => {
		item.addEventListener("change", (evt) => {
			const checkBox = evt.target;
			// Ajax를 사용할 때 요즘 많이 사용하는 순수 자바스크립트 함수: fetch()
			fetch(`/todo/complete?tNo=\${checkBox.id}&complete=\${checkBox.checked}`)
			.then(response => response.json())
			.then(data => {
				console.log(data.result);
				if (data.result === "success") {
					if (checkBox.checked) {
						checkBox.parentElement.parentElement.style.textDecoration="line-through";
					} else {
						checkBox.parentElement.parentElement.style.textDecoration="none";
					}
					checkBox.parentElement.parentElement.children[3].textContent = data.complete ? "완료":"미완료";
				}
			});
		});
	});
</script>
</body>
</html>










