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
	String page1 = request.getParameter("page1");
	int value = (int)session.getAttribute(page1);
	session.setAttribute(page1, value+1);
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
<h2>S인지 N인지? </h2>
<div align=center>
	<form action="./page7.jsp" method="post">
		<input type="radio" name="page1" value="S">S
		<input type="radio" name="page1" value="N">N
		<br><input type="submit" value="다음질문">
	</form>
</div>
</body>
</html>