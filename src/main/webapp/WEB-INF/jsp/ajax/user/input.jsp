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
	<!-- <form method="get" action="/ ajax/user/add" id="saveForm"> -->
		<label>이름</label> <input type="text" name="name" id="nameInput">
		<label>생년월일</label> <input type="text" name="yyyymmdd" id="yyyymmddInput">
		<label>이메일</label> <input type="text" name="email" id="emailInput">
		<button type="submit" id="saveBtn">저장</button>
	<!--</form>-->
	
	<script>
		$(document).ready(function(){
			
			$("#saveBtn").on("click",function(){
				let name = $("#nameInput").val();
				let yyyymmdd = $("#yyyymmddInput").val();
				let email = $("#emailInput").val();
				
				$.ajax({
					type:"get"
					, url:"/ajax/user/add"
					, data:{"name":name, "yyyymmdd":yyyymmdd,"email":email}
					, success:function(data){
						if(data.result=="success"{
							location.href="/ajax/user/list";
						} else{
							alert("저장실패");
						}
					}
					, error:function(){}
						alert("저장 에러!")
				});
			});
			//이벤트 이름 이벤트 실행후 함수
			/*
			$("#saveForm").on("submit", function(){
				let name = $("#nameInput").val();
				
				if(name == ""){
					alert("이름을 입력하세요");
					return false;
				}
				
			});
			*/
		});
	</script>
</body>
</html>