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
	<form action="./page9.jsp" method="post">
		<p>Q8/Q12</p>
		<h4>가장 친한 친구와 좋아하는 선배가 겹친걸 나만 알게됐다 나는?</h4>
		<table id=table>
			<tr>
				<td><label><input type="radio" name="page1" value="F" required="required">음.. 많이 좋아하나? 나는 일단 모른 척 해야겠다</label></td>
			</tr>
			<tr>
				<td><label><input type="radio" name="page1" value="T">선택은 그 선배가 하는거니까 상관없지 않나?</label></td>
			</tr>
		</table>
			<br><input type="submit" value="다음질문" id="submit">
	</form>
</div>

</body>
</html>