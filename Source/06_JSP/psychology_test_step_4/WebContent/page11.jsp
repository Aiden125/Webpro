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
	<form action="./page12.jsp" method="post">
		<p>Q11/Q12</p>
		<h4>학교가는 중 교수님께 온 휴강 문자 나는?</h4>
		<table id=table>
			<tr>
				<td><label><input type="radio" name="page1" value="P" required="required">개이득? 일단 기분이 좋고 당장 비게 된 시간에 뭐할지 생각한다</label></td>
			</tr>
			<tr>
				<td><label><input type="radio" name="page1" value="J">아 어차피 나중에 보강할텐데 미리 좀 알려주지..</label></td>
			</tr>
		</table>
			<br><input type="submit" value="다음질문" id="submit">
	</form>
</div>

</body>
</html>