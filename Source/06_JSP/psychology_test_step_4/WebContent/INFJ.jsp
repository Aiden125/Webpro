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
		<h3>심리학과 닥터스트레인지</h3>
		<form action="./index.jsp" method="post">
			<p>-감수성 풍부 1위</p>
			<p>-뭐든 행동할 때 시뮬레이션을 돌려봄</p>
			<p>-본인의 감정만큼 주변인들의 감정도 신경을 많이 쓰는 편</p>
			<p>-무엇을 하나 살 때도 이게 정말 필요할까 따지며 사기 때문에 선택장애라는 이야기를 듣곤하나, 기분이 안좋은 날엔 충동구매를 하는 경우도 꽤 있음</p>
			<br><input type="submit" value="다시하기" id="submit">
	</form>
</div>
</body>
</html>