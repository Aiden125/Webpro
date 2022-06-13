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
	<form action="./page7.jsp" method="post">
		<p>Q6/Q12</p>
		<h4>수강신청에 제대로 실패했다 나는?</h4>
		<table id=table>
			<tr>
				<td><label><input type="radio" name="page1" value="S" required="required">존버가 최고지 빠지는 자리가 없는지 뚫어지게 본다</label></td>
			</tr>
			<tr>
				<td><label><input type="radio" name="page1" value="N">몇시가 사람이 젤 많이 빠지려나? 그 때 노려야겠다</label></td>
			</tr>
		</table>
			<br><input type="submit" value="다음질문" id="submit">
	</form>
</div>

</body>
</html>