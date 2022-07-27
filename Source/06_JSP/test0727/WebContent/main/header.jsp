<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<div id="header">
		애플리케이션 배포
	</div>
	<div id="menu">
		<ul>
			<li><a href="<%=conPath%>/member/joinForm.jsp">회원등록</a></li>
			<li><a href="<%=conPath%>/member/list.jsp">회원조회/수정</a></li>
			<li><a href="<%=conPath%>/member/bothList.jsp">매출조회(회원/제품)</a></li>
			<li><a href="<%=conPath%>/member/list.jsp">홈으로</a></li>
		</ul>
	</div>
</body>
</html>