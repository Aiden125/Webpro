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
		<h3>작곡과 아이유</h3>
		<form action="./index.jsp" method="post">
			<p>-MBTI에 꽤나 진심임</p>
			<p>-영화, 드라마를 보며 가끔 혼자 울곤함</p>
			<p>-되는대로 살지만 항상 열심히해야겠다라는 생각을 깔고 살아감</p>
			<p>-항상 본인의 감정에 충실한 편에다가 섬세하기에 예술성이 있는 편</p>
			<br><input type="submit" value="다시하기" id="submit">
	</form>
</div>
</body>
</html>