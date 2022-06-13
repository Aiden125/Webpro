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
	<form action="./page4.jsp" method="post">
		<p>Q3/Q12</p>
		<h4>점심시간이 되었다. 혼밥할까?</h4>
		<table id=table>
			<tr>
				<td><label><input type="radio" name="page1" value="E" required="required">같이 먹을 수 있는데 굳이?</label></td>
			</tr>
			<tr>
				<td><label><input type="radio" name="page1" value="I">혼밥해도 될만한거면 혼밥하지 뭐</label></td>
			</tr>
		</table>
			<br><input type="submit" value="다음질문" id="submit">
	</form>
</div>
</body>
</html>