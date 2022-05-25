<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>

							<!-- 쿠키를 만들어보자 -->
							<!-- 쿠키 유효시간 할당 -->
							<!-- response에 탑재(즉, 응답으로 쿠키증정) -->
							<!-- 쿠키 이름 불러오기 -->
							<!-- 쿠키 값 불러오기 -->

<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
	Cookie cookie = new Cookie("cookieName", "cookieValue"); //쿠키 생성
	cookie.setMaxAge(60*60); //1시간 유효한 쿠키 매개변수에 -1넣으면 로그아웃 할 때까지 쿠키보유
	response.addCookie(cookie); // resonse에 탑재
%>
	<h2>지금 막 생성된 쿠키 이름 : <%=cookie.getName() %></h2>
	<h2>지금 막 생성된 쿠키 값 : <%=cookie.getValue() %></h2>
	<a href="ex2_cookieList.jsp">쿠키들(쿠키이름, 쿠키값) 리스트 확인</a> <br>
	<a href="ex3_thatCookie.jsp">특정 쿠키(이름이 cookieName) 찾기</a> <br>
	<a href="ex4_cookieDle.jsp">쿠키 삭제</a>
</body>
</html>