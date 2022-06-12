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
	session.setAttribute("E", 0);
	session.setAttribute("I", 0);
	session.setAttribute("S", 0);
	session.setAttribute("N", 0);
	session.setAttribute("F", 0);
	session.setAttribute("T", 0);
	session.setAttribute("P", 0);
	session.setAttribute("J", 0);
%>

<h2> E : <%=session.getAttribute("E") %>
I : <%=session.getAttribute("I") %>
S : <%=session.getAttribute("S") %>
N : <%=session.getAttribute("N") %>
F : <%=session.getAttribute("F") %>
T : <%=session.getAttribute("T") %>
P : <%=session.getAttribute("P") %>
J : <%=session.getAttribute("J") %></h2>


<h1>< 심리테스트 ></h1>
<h2>당신은 E인가요 I인가요?111 </h2>
<div align=center>
	<form action="./page2.jsp" method="post">
		<input type="radio" name="page1" value="E">E
		<input type="radio" name="page1" value="I">I
		<input type="radio" name="page1" value="S">S
		<input type="radio" name="page1" value="N">N
		<input type="radio" name="page1" value="F">F
		<input type="radio" name="page1" value="T">T
		<input type="radio" name="page1" value="P">P
		<input type="radio" name="page1" value="J">J
		<br><input type="submit" value="다음질문">
	</form>
</div>
</body>
</html>