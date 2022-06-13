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
	<form action="./page6.jsp" method="post">
		<p>Q5/Q12</p>
		<h4>반갑게 인사하며 지나가는 친구에게 인사를 했다. 하지만 이름이 기억나지 않는다 나는?</h4>
		<table id=table>
			<tr>
				<td><label><input type="radio" name="page1" value="S">쟤 이름이 뭐였지? 이따 친구한테 물어봐야겠다.</label></td>
			</tr>
			<tr>
				<td><label><input type="radio" name="page1" value="N">쟤 이름이 뭐였더라? 괜히 스스로 떠올리고 싶은 오기가 생긴다.</label></td>
			</tr>
		</table>
			<br><input type="submit" value="다음질문" id="submit">
	</form>
</div>
</body>
</html>