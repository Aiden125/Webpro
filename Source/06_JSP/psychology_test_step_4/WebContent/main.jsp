<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String conPath = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
<style>
	h3{
		margin-top:100px;
	}
</style>
</head>
<body>
<%
	session.setAttribute("E", 0);
	session.setAttribute("I", 0);
	session.setAttribute("S", 0);
	session.setAttribute("N", 0);
	session.setAttribute("F", 0);
	session.setAttribute("T", 0);
	session.setAttribute("P", 0);
	session.setAttribute("J", 0);
%>
<div id=wrap>
		<h3>자고 일어났는데 20살, <br>대학교 1학년이 되어있다면?</h3>
		<table id=table>
		</table>
			<br><input type="button" onclick="location.href='./page1.jsp'" value="시작하기" id="submit">
</div>
</body>
</html>