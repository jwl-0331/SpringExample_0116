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
		<label>이름</label> <input type="text" name="name" id="nameInput"> <br>
		<label>생년월일</label> <input type="text" name="yyyymmdd" id="yyyymmddInput"> <br>
		<label>이메일</label> <input type="text" name="email" id="emailInput">
		<button type="button" id="duplicateBtn">중복확인</button>
		 <br>
		<button type="button" id="saveBtn">저장</button>
	<!--</form>-->
	
	<script>
		$(document).ready(function(){
			//중복성 검사 여부 확인 -전역변수
			var isChecked = false;
			
			$("#duplicateBtn").on("click",function(){
				let email = $("#emailInput").val();
				//유효성검사 (validation)
				if(email == ""){
					alert("이메일 입력하세요.");
					return;
				}
				
				$.ajax({
					type:"get"
					, url:"/ajax/user/is_duplicate"
					, data:{"email": email}
					, success:function(data){
						//중복 체크 여부 상태 저장
						isChecked = true;
						if(data.is_duplicate == true){
							//중복된상태
							alert("중복되었습니다.");
						}else{
							//중복되지 않음
							alert("사용가능 합니다.");
						}
					}
					, error:function(){
						alert("중복확인 에러");
					}
					
				});
			});
			
			$("#saveBtn").on("click",function(){
				let name = $("#nameInput").val();
				let yyyymmdd = $("#yyyymmddInput").val();
				let email = $("#emailInput").val();
				
				//validation
				if (name == ""){
					alert("이름을 입력하세요.");
					return;
				}
				
				if(yyyymmdd== ""){
					alert("생년월일을 입력하세요.");
					return;
				}
				
				if(email == ""){
					alert("이메일을 입력하세요.");
					return;
				}
				//유효성 검사
				//중복 체크를 했는지
				if(!isChecked){
					alert("중복여부 체크를 해주세요");
					return;
				}
				//중복 되었는지
				
				$.ajax({
					//request 옵션들
					type:"get"
					, url:"/ajax/user/add"
					, data:{"name":name, "yyyymmdd":yyyymmdd,"email":email}
					//response 옵션
					, success:function(data){
						//{"result":"success"} or "fail"
						if(data.result == "success"){
							//성공했을때 페이지를 이동시켜준다
							location.href="/ajax/user/list";
						} else{
							alert("저장실패");
						}
					}
					, error:function(){
						alert("저장 에러!")
					}
				});
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
	</script>
</body>
</html>