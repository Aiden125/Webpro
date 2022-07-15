<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>현재 총 ${cnt } 명</h2>
	<form action="${conPath }/quizInput.do" method="post">
		<p>이름 : <input type="text" name="name" value="${quiz.name }">
		<%-- <p>ID : <input type="number" name="id" placeholder="ID는 자연수" value='<c:if test="${student.id!=0}">${student.id}</c:if>'></p> --%>
		<p>국어 : <input type="number" name="kor"></p>
		<p>영어 : <input type="number" name="eng"></p>
		<p>수학 : <input type="number" name="math"></p>
		<input type="submit">
	</form>
	<h4>${nameError }</h4>
	<h4>${scoreError }</h4>
</body>
</html>