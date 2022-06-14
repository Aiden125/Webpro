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
	<h2>현재 파일은 ex2_View.jsp 파일</h2>
	<h3>회원정보</h3>
	<h2>ID : ${member.id }</h2>
	<h2>PW : ${member.pw }</h2>
	<h2>등록일 : ${member.rdate }</h2>
	<hr>
	<h3>넘어온 파라미터 ID : ${param.id }</h3>
	<h3>넘어온 파라미터 PW : ${param.pw }</h3>
	<button onclick="history.back()">이전으로</button>
</body>
</html>