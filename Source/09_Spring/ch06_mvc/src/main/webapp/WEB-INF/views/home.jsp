<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	
	<!-- 따로 처리해줬기 때문에 conPath 빼도 상관 x -->
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
<h1>
	${greeting }
</h1>

<p>The time on the server is ${serverTime}. </p>
<p>한글</p>
<p><img src="img/102.jpg" alt="test"></p>
<p><img src="${conPath }/img/102.jpg" alt="test"></p>
</body>
</html>
