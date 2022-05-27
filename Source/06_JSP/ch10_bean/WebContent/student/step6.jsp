<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="p" class="com.lec.ex.Student" scope="request"/>
	<jsp:setProperty name="p" property="*"/>
	<jsp:forward page="sView.jsp"/>
</body>
</html>