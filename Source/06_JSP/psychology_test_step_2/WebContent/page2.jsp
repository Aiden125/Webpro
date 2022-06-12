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


<h2> A : <%=session.getAttribute("A") %>
B : <%=session.getAttribute("B") %>
C : <%=session.getAttribute("C") %>
D : <%=session.getAttribute("D") %>
E : <%=session.getAttribute("E") %>
F : <%=session.getAttribute("F") %>
G : <%=session.getAttribute("G") %>
H : <%=session.getAttribute("H") %></h2>


<%
	String [] array = {"A", "B", "C", "D", "E", "F", "G", "H"};
	int MAX = (int)session.getAttribute(array[0]);
	String choice = "";
	for(int i=0; i<8; i++){
		if(MAX < (int)session.getAttribute(array[i])){
			MAX = (int)session.getAttribute(array[i]);
			choice = array[i];
		}
	}
	if(choice.equals("A")) choice = "짜장면";
	if(choice.equals("B")) choice = "간짜장";
	if(choice.equals("C")) choice = "군만두";
	if(choice.equals("D")) choice = "짬뽕";
	if(choice.equals("E")) choice = "볶음밥";
	if(choice.equals("F")) choice = "탕수육";
	if(choice.equals("G")) choice = "간짬뽕";
	if(choice.equals("H")) choice = "짬짜면";
%>
<h1>< 심리테스트 ></h1>
<h2>당신이 좋아하는 음식은?22</h2>
<div align=center>
	<form action="page3.jsp" method="post">
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