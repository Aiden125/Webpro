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
	<form action="./page5.jsp" method="post">
		<p>Q4/Q12</p>
		<h4>내 뒷담을 까고 다니는 친구가 있다는 소문이 들려온다</h4>
		<table id=table>
			<tr>
				<td><label><input type="radio" name="page1" value="S" required="required">진짠가? 다른애들한테 좀 물어봐야겠다</label></td>
			</tr>
			<tr>
				<td><label><input type="radio" name="page1" value="N">내가 걔한테 뭐 했나? 일단 지켜보자</label></td>
			</tr>
		</table>
			<br><input type="submit" value="다음질문" id="submit">
	</form>
</div>
</body>
</html>