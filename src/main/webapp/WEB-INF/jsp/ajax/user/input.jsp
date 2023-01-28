<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자등록화면</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>
<body>
	<form method="get" action="/ ajax/user/add">
		<label>이름</label> <input type="text" name="name" id="nameInput">
		<label>생년월일</label> <input type="text" name="yyyymmdd">
		<label>이메일</label> <input type="text" name="email">
		<button type="submit" id="saveBtn">저장</button>
	</form>
	
	<script>
		$(document).ready(function(){
			//이벤트 이름 이벤트 실행후 함수
			$("#saveBtn").on("click", function(){
				let name = $("#nameInput").val();
				
				if(name == ""){
					alert("이름을 입력하세요");
					return;
				}
				
			});
		});
	</script>
</body>
</html>