<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 포맷</title>
</head>
<body>
	<h2>JSTL 포맷 라이브러리</h2>
	
	<c:set var="number" value="12345678"/>
	<h3>숫자 출력</h3>
	<h4><fmt:formatNumber value="${number }"/> </h4>
	
	<h3>percent</h3>
	<h4><fmt:formatNumber value="0.35" type="percent"/></h4>
	<h4><fmt:formatNumber value="1" type="percent"/></h4>
	<h4><fmt:formatNumber value="${3/5}" type="percent"/></h4>
	
	<h3>통화</h3>
	<h4><fmt:formatNumber value="${number }" type="currency"/></h4>
	<h4><fmt:formatNumber value="${number }" type="currency" currencySymbol="$"/></h4>
	
	<fmt:formatNumber value="${number }" type="currency" var="dollor"/>
	<h4>${dollor}</h4>
	
	<h3>숫자 소수점 패턴</h3>
	<c:set var="pi" value="3.1415926535"/>
	<h4>${pi }</h4>
	<h4><fmt:formatNumber value="${pi}" pattern="#.##"/></h4>
	<h4><fmt:formatNumber value="${pi}" pattern="#.####################"/></h4>
	<h4><fmt:formatNumber value="${pi}" pattern="0.00000000000000000000"/></h4>
	
	<hr>
	<h3>날짜 포맷</h3>
	<h4>${now }</h4>
	<h4><fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일" /></h4>
	<%-- "2023/01/19 21:44:10" --%>
	<fmt:parseDate value="${dateString }" pattern="yyyy/MM/dd HH:mm:ss" var="date"/>
	<h4>${date }</h4>
</body>
</html>