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
	<h2><%=age %>살 성인이니 주류 구매가능</h2>
	<button onclick="history.back();">뒤로가기</button>

</body>
</html>