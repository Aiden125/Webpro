<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<c:set var="visitNum" value="${param.visitNum }"/>
	<c:if test="${visitNum eq 0 }">
		<h2>첫 방문 감사</h2>
	</c:if>
	<c:if test="${visitNum > 0  && visitNum < 5}">
		<h2>재방문 감사</h2>
	</c:if>
	<c:if test="${visitNum >=5 }">
		<h2>자주 방문 감사</h2>
	</c:if>
	<c:if test="${visitNum < 0 }">
		<h2>잘못 입력하셨습니다</h2>
	</c:if>
</body>
</html>