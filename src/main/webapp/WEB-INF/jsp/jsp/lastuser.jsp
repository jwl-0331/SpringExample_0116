<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>최근 사용자</title>
</head>
<body>
	<h1>${title} </h1>
	<table border="1">
		<tr>
			<th>id</th>
			<td>${user.id}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${user.name}</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>${user.yyyymmdd}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${user.email}</td>
		</tr>
		<tr>
			<th>자기소개</th>
			<td>${user.introduce}</td>
		</tr>
	</table>
</body>
</html>