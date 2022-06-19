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
		<h3>산업공학과 김구라</h3>
		<form action="./index.jsp" method="post">
			<p>-효율을 굉장히 따짐</p>
			<p>-효율을 너무 따져 효율을 잃어버리는 경우가 있음</p>
			<p>-굉장히 논리정연한 사고를 가져 말싸움에서 지는 경우가 거의 없음</p>
			<p>-본인에게도 냉정한 편이며, 계획도 체계적이어 부지런해보이지만 실상 꽤나 게으른 편임</p>
			<br><input type="submit" value="다시하기" id="submit">
	</form>
</div>
</body>
</html>