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
	<form action="./lastpage.jsp" method="post">
		<p>Q12/Q12</p>
		<h4>학교 내에서 맘에 드는 사람이 생겼다 나는?</h4>
		<table id=table>
			<tr>
				<td><label><input type="radio" name="page1" value="P" required="required">어떻게 고백하는게 가장 좋지? 고백에 대한 생각부터 한다.</label></td>
			</tr>
			<tr>
				<td><label><input type="radio" name="page1" value="J">나 말고 관심 보이는 사람이 또 있었나? 주변사람부터 떠올려본다.</label></td>
			</tr>
		</table>
			<br><input type="submit" value="다음질문" id="submit">
	</form>
</div>

</body>
</html>