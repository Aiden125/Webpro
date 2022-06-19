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
		<h3>철학과 정형돈</h3>
		<form action="./index.jsp" method="post">
			<p>-고독을 즐기는 편</p>
			<p>-이런저런 생각이 많아 쓸데없는 생각으로 자주 빠짐</p>
			<p>-평소 말도 리액션도 적지만 본인이 아는 분야에선 말도 많고 리액션도 커짐</p>
			<p>-친구가 있지만 대부분 관심사가 통하는 친구들이며, 다수의 친구들과 얕게보단 소수 친구들과 깊게 사귀는 편</p>
			<br><input type="submit" value="다시하기" id="submit">
	</form>
</div>
</body>
</html>