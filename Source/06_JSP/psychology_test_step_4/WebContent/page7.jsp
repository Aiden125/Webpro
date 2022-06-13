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
	<form action="./page8.jsp" method="post">
		<p>Q7/Q12</p>
		<h4>동기가 성적 때문에 우울해하고 있다 나는?</h4>
		<table id=table>
			<tr>
				<td><label><input type="radio" name="page1" value="F" required="required">괜찮아?이번에 어렵긴 했어ㅠㅠ</label></td>
			</tr>
			<tr>
				<td><label><input type="radio" name="page1" value="T">뭐야 그래도 나보다 잘 봤는데?</label></td>
			</tr>
		</table>
			<br><input type="submit" value="다음질문" id="submit">
	</form>
</div>

</body>
</html>