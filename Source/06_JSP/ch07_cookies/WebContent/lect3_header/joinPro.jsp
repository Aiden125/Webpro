<%@page import="java.sql.Date"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>

				<!-- 현재 이 화면을 바꾼 이유는 DB에 데이터를 넣는 역할로 바꾸기 위해
				즉, 로그인이 되었으면 DB에만 데이터 넣어주고메인창으로 보내주기 위한 창
				(화면으로 만들것이 아니라는 것)-->

<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String name       = request.getParameter("name");
	String id     		= request.getParameter("id");
	String pw 				= request.getParameter("pw");
	String birthTemp  = request.getParameter("birth");
	Date birth = null;
	if(!birthTemp.equals("")){
		birth = Date.valueOf(request.getParameter("birth")); 
	}
	String[] hobby 		= request.getParameterValues("hobby");
	String gender 		= request.getParameter("gender");
	String email 			= request.getParameter("email");
	String[] mailSend = request.getParameterValues("mailSend");
	// DB저장
%>
	<script>
		alert('회원가입이 완료되었습니다. 감사합니다');
		location.href='login.jsp';
	</script>
</body>
</html>










