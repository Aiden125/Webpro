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
<% //로그인 상태라면 : id, name 세션이 유효할 것.
	String name = (String)session.getAttribute("name");
	if(name!=null){
		//session.removeAttribut("id");
		//session.removeAttribut("name");
		session.invalidate(); //한번에 지우기
		out.println("<h2>성공적으로 로그아웃 되었습니다");
	}else { //로그인 되어있지 않은 상태
		out.println("<h2>로그인 상태가 아닙니다.");
	}
%>	
	<button onclick="location.href='login.jsp'">로그인</button>
	<button onclick="location.href='sessionTest.jsp'">세션 들여다보기</button>
</body>
</html>