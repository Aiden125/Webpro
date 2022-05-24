<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath  %>/css/exam1.css" rel="stylesheet">
</head>
<body>
<form action="ex.jsp">
<%
	int num = (int)(Math.random()*3);
	String ch1 = request.getParameter("ch1");
	String ch2 = request.getParameter("ch2");
	String ch3 = request.getParameter("ch3");
	if((num==0 && ch1==null) || (num==1 && ch2==null) || (num==2 && ch3==null)){
		//String msg = "Check the ID and PW";
		String msg = "<p>Wrong! Try Again! 정답은 "+(num+1)+"번 입니다</p>";
		msg = URLEncoder.encode(msg, "utf-8");
		response.sendRedirect("ex.jsp?msg="+msg);
	}
	
%>
	<table>
		<tr>
			<th colspan="3">동전이 있는 곳을 맞춰봐</th>
		</tr>
		
		<tr>
			<td>
			<p>정답입니다<p>
			<p>동전이 있던 곳은 <%=(num+1) %>번<p>
			<input type="submit" value="다시 도전">
			</td>
		</tr>
	</table>
</form>
</body>
</html>