<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
	//post방식이기 때문에 인코딩 해주고,
	//파라미터 받아오고 세션에 넣어주기(다음페이지로 넘겨야 하기에)
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	session.setAttribute("id", id);
	session.setAttribute("pw", pw);
	session.setAttribute("name", name);
%>
	<h2><%=name %>님 약관에 동의하십니까?</h2>
	<hr>
	<ol>
		<li>회원정보는 웹사이트 운영을 위해서만 사용합니다.</li>
		<li>운영에 방해되는 회원은 탈퇴처리 됩니다.</li>
	</ol>
	<hr>
	<fieldset>
		<legend>약관 동의</legend>
		<form action="joinOk.jsp">
			<input type="radio" name="agree" value="y">동의
			<input type="radio" name="agree" value="n" checked="checked">비동의
			<input type="submit" value="확인">
		</form>
	</fieldset>
	
</body>
</html>