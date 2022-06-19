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
		<h3>정치외교학과 장도연</h3>
		<form action="./index.jsp" method="post">
			<p>-친구들 사이 정보통</p>
			<p>-감정기복이 굉장히 심한편이나 그만큼 세세한 감정을 갖고 있는 편</p>
			<p>-주변에 재밌는 소식이 들려오면 이를 전파하는 매개체 역할을 간혹 하곤함 </p>
			<p>-사람을 좋아하는 편이지만 본인이 좋아하는 사람과 싫어하는 사람의 경계가 명확한 편</p>
			<br><input type="submit" value="다시하기" id="submit">
	</form>
</div>
</body>
</html>