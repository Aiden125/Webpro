<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1{
	font-size:30px;
	text-align:center;
}
h2{
	font-size:20px;
	text-align:center;
}
</style>
</head>
<body>
<%
	session.setAttribute("A", 0);
	session.setAttribute("B", 0);
	session.setAttribute("C", 0);
	session.setAttribute("D", 0);
	session.setAttribute("E", 0);
	session.setAttribute("F", 0);
	session.setAttribute("G", 0);
	session.setAttribute("H", 0);
%>

<h2> A : <%=session.getAttribute("A") %>
B : <%=session.getAttribute("B") %>
C : <%=session.getAttribute("C") %>
D : <%=session.getAttribute("D") %>
E : <%=session.getAttribute("E") %>
F : <%=session.getAttribute("F") %>
G : <%=session.getAttribute("G") %>
H : <%=session.getAttribute("H") %></h2>

<h1>< 심리테스트 ></h1>
<h2>당신이 좋아하는 음식은?</h2>
<div align=center>
	<form action="./page2.jsp" method="post">
		<input type="radio" name="page1" value="A">짜장면
		<input type="radio" name="page1" value="B">간짜장
		<input type="radio" name="page1" value="C">군만두
		<input type="radio" name="page1" value="D">짬뽕
		<input type="radio" name="page1" value="E">볶음밥
		<input type="radio" name="page1" value="F">탕수육
		<input type="radio" name="page1" value="G">간짬뽕
		<input type="radio" name="page1" value="H">짬짜면
		<br><input type="submit" value="다음질문">
	</form>
</div>
</body>
</html>