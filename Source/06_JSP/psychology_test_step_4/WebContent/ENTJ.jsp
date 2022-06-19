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
		<h3>기계공학과 스윙스</h3>
		<form action="./index.jsp" method="post">
			<p>-기본적으로 일머리가 있는 편</p>
			<p>-답답한 걸 못참기 때문에 답답한 장면을 보면 하던일도 내팽개치고 나서서 하는 편</p>
			<p>-조별과제에서 답답함을 못참고 5할 이상을 혼자 하는 편</p>
			<p>-해결력이 주변친구들에게 많은 도움을 주고 그에 대한 인정을 어느정도 받지만 비교적 냉정한 성격 탓에 간혹 본인도 모르게 주변에 상처를 주기도 하는 편</p>
			<br><input type="submit" value="다시하기" id="submit">
	</form>
</div>
</body>
</html>