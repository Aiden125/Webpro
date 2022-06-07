
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
	<!-- #forward방식이 아닌 sendRedirect로 바꿔준다. -->
	<%response.sendRedirect("board/list.jsp"); %>
</body>
</html>