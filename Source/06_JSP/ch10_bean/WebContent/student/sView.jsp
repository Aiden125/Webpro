<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<!-- 뷰단 -->
	<jsp:useBean  class="com.lec.ex.Student" id="p" scope="request"/>
	<h2>입력된 개인정보</h2>
	<p>학번 <jsp:getProperty property="no" name="p"/></p>
	<p>이름 <jsp:getProperty property="name" name="p"/></p>
	<p>학년 <jsp:getProperty property="level" name="p"/></p>
	<p>반 <jsp:getProperty property="ban" name="p"/></p>
	<p>점수 <jsp:getProperty property="score" name="p"/></p>
</body>
</html>