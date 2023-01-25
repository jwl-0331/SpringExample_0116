<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 코어 라이브러리</title>
</head>
<body>
	<h2>조건문 반복문</h2>
	
	<h3>if else</h3>
	<%-- 몸무게가 70 이하면 치킨, 몸무게 80 이하면 샐러드 그게 아니면 굶어  --%>
	<c:choose>
		<c:when test="${weight <= 70 }">
			<h4>치킨</h4>
		</c:when>
		<c:when test="${weight <= 80 }">
			<h4>샐러드</h4>
		</c:when>
		<%-- else --%>
		<c:otherwise>
			<h4>굶어</h4>
		</c:otherwise>
	</c:choose>
	
	<h3>반복문</h3>
	<%-- for(int i = 0 ; i <5; i++) --%>
	<c:forEach var="i" begin="0" end="4" step="1">
		${i}
	</c:forEach>
	
	<%-- for(String fruit:fruitList) --%>
	<c:forEach var="fruit" items="${fruitList}" varStatus="status">
		<h4>${fruit } ::: ${status.count } ${status.index} ${status.first} ${status.last}</h4>
	</c:forEach>
	
	<table border=1>
		<thead>
			<tr>
				<th>이름</th>
				<th>나이</th>
				<th>취미</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList }">
			<tr>
				<td>${user.name }</td>
				<td>${user.age }</td>
				<td>${user.hobby }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>