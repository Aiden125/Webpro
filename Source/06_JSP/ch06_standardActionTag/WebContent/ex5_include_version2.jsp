<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
						<!-- jsp:include page="파일이름" 이런식으로
						표준 인클루드를 활용하면 version1처럼 conPath겹치는
						문제를 해결할 수 있음  -->
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>ex5_include.jsp 페이지입니다</h1>
	<h2>반갑습니다</h2>
	<jsp:include page="includePage.jsp"/> <!-- jsp파일의 결과를 include -->
</body>
</html>