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
	<form action="./page10.jsp" method="post">
		<p>Q9/Q12</p>
		<h4>술마신 다음 날 늦은 오후까지 연락이 안되는 친구 나는?</h4>
		<table id=table>
			<tr>
				<td><label><input type="radio" name="page1" value="F" required="required">그래도 그렇지 이정도면 무슨일 있는거 아니야?</label></td>
			</tr>
			<tr>
				<td><label><input type="radio" name="page1" value="T">늦게까지 자네</label></td>
			</tr>
		</table>
			<br><input type="submit" value="다음질문" id="submit">
	</form>
</div>

</body>
</html>