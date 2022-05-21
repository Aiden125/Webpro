<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
	// request는 내장객체로써 바로 이용가능하며, 받은 파라미터값은 String
	int su = Integer.parseInt(request.getParameter("su"));
%>
	<h3><%=su %>단 구구단 출력</h3>
	<table>
		<%
		for(int i=1; i<=9; i++){%>
			<tr><td> <%=su %> * <%=i %> = <%=su*i %> </td></tr>
			<%} %>
	</table>	
</body>
</html>