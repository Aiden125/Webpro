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
		<h3>언론홍보학과 정상수</h3>
		<form action="./index.jsp" method="post">
			<p>-한 고집 하는 편</p>
			<p>-자존심이 상하더라도 티는 안내지만 속에서는 열불이 끓음</p>
			<p>-자신이 맞다고 생각하면 굳이 상대를 위해 져줄 필요가 없다고 생각</p>
			<p>-말싸움에 능해 주변 사람이 억울한 일을 당하면 본인이 나서서 해결하는 경우가 있다.</p>
			<br><input type="submit" value="다시하기" id="submit">
	</form>
</div>
</body>
</html>