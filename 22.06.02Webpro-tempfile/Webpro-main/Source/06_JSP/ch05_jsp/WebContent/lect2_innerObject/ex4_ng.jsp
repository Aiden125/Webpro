<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!--  age.html -> age.jsp -> pass.jsp  -->
<%
	int age = Integer.parseInt(request.getParameter("age"));
%>	
	<h2><%=age %>살로, 성인이 아니기에 주류 구매 불가</h2>
	<button onclick="history.back();">뒤로가기</button>
</body>
</html>