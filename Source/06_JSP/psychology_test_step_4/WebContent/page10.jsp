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
	<form action="./page11.jsp" method="post">
		<p>Q10/Q12</p>
		<h4>MT 장기자랑을 하게 되었다 나는?</h4>
		<table id=table>
			<tr>
				<td><label><input type="radio" name="page1" value="P" required="required">분위기가 중요하지 그냥 분위기 맞춰 아무거나 해야겠다</label></td>
			</tr>
			<tr>
				<td><label><input type="radio" name="page1" value="J">요즘 괜찮은 거 없나? 찾아보고 시험보다 열심히 준비한다</label></td>
			</tr>
		</table>
			<br><input type="submit" value="다음질문" id="submit">
	</form>
</div>

</body>
</html>