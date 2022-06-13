<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String conPath = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
<%
	String page1 = request.getParameter("page1");
	int value = (int)session.getAttribute(page1);
	session.setAttribute(page1, value+1);
%>

<div id=wrap>
	<form action="./page3.jsp" method="post">
		<p>Q2/Q12</p>
		<h4>아직은 어색한 무리가 더 놀자고 한다 나는?</h4>
		<table id=table>
			<tr>
				<td><label><input type="radio" name="page1" value="E" required="required">즐겨야지 일단 가보자</label></td>
			</tr>
			<tr>
				<td><label><input type="radio" name="page1" value="I">좀 더 친해지면 가자</label></td>
			</tr>
		</table>
			<br><input type="submit" value="다음질문" id="submit">
	</form>
</div>
</body>
</html>