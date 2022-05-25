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
<form action="exPro.jsp">
	<table>
		<tr>
			<th colspan="3">동전이 있는 곳을 맞춰봐</th>
		</tr>
		<tr>
			<td><button value="0" name="ch1" class="btn">1번</button></td>
			<td><button value="1" name="ch2" class="btn">2번</button></td>
			<td><button value="2" name="ch3" class="btn">3번</button></td>
		</tr>
	</table>
<div id="msg">
<%
		String msg = request.getParameter("msg");
		if(msg!=null){
			out.print(msg);
		}
	%>
</div>
</form>
</body>
</html>