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


<%
	String [] array = {"E", "I", "S", "N", "F", "T", "P", "J"};
	int MAX = (int)session.getAttribute(array[0]);
	String choice = "E";
	for(int i=0; i<8; i++){
		if(MAX < (int)session.getAttribute(array[i])){
			MAX = (int)session.getAttribute(array[i]);
			choice = array[i];
		}
	}
	if(choice.equals("E")) choice = "E";
	if(choice.equals("I")) choice = "I";
	if(choice.equals("S")) choice = "S";
	if(choice.equals("N")) choice = "N";
	if(choice.equals("F")) choice = "F";
	if(choice.equals("T")) choice = "T";
	if(choice.equals("P")) choice = "P";
	if(choice.equals("J")) choice = "J";
%>
<div align="center">
	<h1>< 결과 ></h1>
	<h2>당신은 <%=choice %>입니다.</h2>
	<form action="./index.jsp" method="post">
		<br><input type="submit" value="다시하기">
	</form>
</div>
</body>
</html>