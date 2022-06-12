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
	String choice1 = "E";
	for(int i=0; i<2; i++){
		if(MAX < (int)session.getAttribute(array[i])){
			MAX = (int)session.getAttribute(array[i]);
			choice1 = array[i];
		}
	}
	MAX = (int)session.getAttribute(array[2]);
	String choice2 = "S";
	for(int i=2; i<4; i++){
		if(MAX < (int)session.getAttribute(array[i])){
			MAX = (int)session.getAttribute(array[i]);
			choice2 = array[i];
		}
	}
	MAX = (int)session.getAttribute(array[4]);
	String choice3 = "F";
	for(int i=4; i<6; i++){
		if(MAX < (int)session.getAttribute(array[i])){
			MAX = (int)session.getAttribute(array[i]);
			choice3 = array[i];
		}
	}
	MAX = (int)session.getAttribute(array[6]);
	String choice4 = "P";
	for(int i=6; i<8; i++){
		if(MAX < (int)session.getAttribute(array[i])){
			MAX = (int)session.getAttribute(array[i]);
			choice4 = array[i];
		}
	}
	if(choice1.equals("E")) choice1 = "E";
	if(choice1.equals("I")) choice1 = "I";
	if(choice2.equals("S")) choice2 = "S";
	if(choice2.equals("N")) choice2 = "N";
	if(choice3.equals("F")) choice3 = "F";
	if(choice3.equals("T")) choice3 = "T";
	if(choice4.equals("P")) choice4 = "P";
	if(choice4.equals("J")) choice4 = "J";
%>
<div align="center">
	<h1>< 결과 ></h1>
	<h2>당신은 <%=choice1 %><%=choice2 %><%=choice3 %><%=choice4 %>입니다.</h2>
	<form action="./index.jsp" method="post">
		<br><input type="submit" value="다시하기">
	</form>
</div>
</body>
</html>