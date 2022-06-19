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
<style>
	p{
		text-align:left;
		margin-left:20px;
	}
</style>
</head>
<body>
<div id=wrap>
		<h2>< 결과 ></h2>
		<h3>연극영화과 김고은</h3>
		<form action="./index.jsp" method="post">
			<p>-깡으로 한 몫 하는 편</p>
			<p>-시작은 잘하는 편이나 한 가지를 오래하지는 못함</p>
			<p>-평소에는 흥이 넘치는 편이지만 어두워질 때는 한 없이 어두워지나 티를 잘 안내려고함</p>
			<p>-본인을 냉정하게 판단해주는 사람보다는 응원하고 격려해주며 에너지를 만들어주는 사람을 선호함</p>
			<br><input type="submit" value="다시하기" id="submit">
	</form>
</div>
</body>
</html>