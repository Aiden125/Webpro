<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>변수 선언과 출력</h2>
	<!-- 변수 선언  -->
	<c:set var="varName" value="varValue"/>
	<!-- 변수 출력(그냥) -->
	varName : ${varName } <br>
	<c:set var="varName" value="<varValue>"/>
	varName : ${varName } <br>
	
	<!-- 변수 출력(꺽새 포함) -->
	varName : <c:out value="${varName }" escapeXml="true"/><br> <!-- escapeXml : 특수문자를 문자로 인식하겠다 -->
	
	<!-- 변수 삭제 -->
	<c:remove var="varName"/><br>
	varName : ${varName }<br>
	varName : ${empty varName ? "삭제됨" : "남아있음" }
	varName : <c:out value="${varName }" default="없어진 변수"/>
</body>
</html>