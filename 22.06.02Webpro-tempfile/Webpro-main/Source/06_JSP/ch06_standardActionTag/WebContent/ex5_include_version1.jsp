<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
						<!-- 스크립 트릿으로   include시키면 그냥 그 파일
						통째로 들어오기 때문에 들어오면서 conPath도 들어오게 됨 
						그래서 들여오는 파일의 conPath를 지우면 해결가능하긴하나
						사실상 conPath쓰기 너무 불편해지기에 이렇게 안쓰는편
						(밑에 있는데 에러표시 때문에 주석해놓음)
						
						
						
						(밑에는 그냥 내가 했던 생각)
						header 및 footer에 둘다 css넣으면 겹칠 수 있음 -->
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>ex5_include.jsp 페이지입니다</h1>
	<h2>반갑습니다</h2>
	<!--  <%@ include file="includePage.jsp" %>--> <!-- jsp파일 원본 그대로 include -->
	<h1>다시 ex5_include.jsp 페이지입니다</h1>
</body>
</html>