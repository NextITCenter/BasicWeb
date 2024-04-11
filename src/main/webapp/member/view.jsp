<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 화면</title>
</head>
<body>
<a href="/member/update?id=${member.id}">수정</a>
<a href="javascript:deleteMember();">삭제</a>
<a href="/member/password?id=${member.id}">비밀번호 수정</a>
<div>
	ID: ${member.id }
</div>
<div>
	이름: ${member.name }
</div>
<div>
	이메일: ${member.email }
</div>
</body>
<script>
	function deleteMember() {
		if (confirm("삭제하시겠습니까?")) {
			location.href = "/member/delete?id=${member.id}"
		} else {
			alert("삭제를 취소하셨습니다.");
		}
	}
</script>
</html>