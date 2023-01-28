<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
	
</head>
<body>
	<h1>Ajax 테스트</h1>
	<div id="text"></div>
	<script>
	//request를 위한 것 (3가지)
		$.ajax({
			type:"get"
			, url:"/ajax/request"
			//, data:{}
			//요청 - 성공하면 function 수행 (data)를 파라미터로 받는다
			// 문자열이 들어가있다 - 문자열 함수 사용 데이터를 쪼개고 등등
			, success: function(data){
				//Jquery 알아서 파씽해서 자바 스크립트의 객체형태로 만들어준다
				alert(data.name);
				$("#text").text(data.age);
			}
			//에러 - 에러가 낫을떄
			, error: function(){
				
			}
		});
	</script>
</body>
</html>