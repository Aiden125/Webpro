<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="exceptionPage.jsp" %>
<%String conPath = request.getContextPath(); %>

<!--  여기 페이지가 에러가 날 수 있는 페이지라면?
1. 맨위에 자바 선언을 통해 여기는 에러가 날 수 있는 페이지이고 에러나면 에러처리 페이지로 보내주라고 하기.
 -->
 
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%! int num1, num2; %>
<%
	num1 = Integer.parseInt(request.getParameter("num1"));
	num2 = Integer.parseInt(request.getParameter("num2"));
	out.println("<h3>num1 = " + num1 + ", num2=" + num2 + "</h3>");
	out.println("<h3>num1 + num2 + " + (num1+num2) + "</h3>");
	out.println("<h3>num1 / num2 + " + (num1/num2) + "</h3>");
	out.println("<h3>num1 - num2 + " + (num1-num2) + "</h3>");
	out.println("<h3>num1 * num2 + " + (num1*num2) + "</h3>");
	out.println("<h3>DONE</h3>");
%>
</body>
</html>