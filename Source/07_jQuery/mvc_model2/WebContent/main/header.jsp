<%@page import="com.lec.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/header.css" rel="stylesheet">
</head>
<body> <%-- gnb(로그인 전 / 로그인 후 다름) - .logo .lnb(로그인 전/로그인 후) --%>
	<header>
		<div class="gnb">
			<%if(session.getAttribute("customer") == null){%>
				<!-- 로그인 전 메뉴(우측부터) : 고객센터, 회원가입, 로그인 -->
				<ul>
					<li><a href="<%=conPath%>/fileboard/fboardList.do">고객센터</a></li>
					<li><a href="<%=conPath %>/customer/joinView.do">회원가입</a></li>
					<li><a href="<%=conPath %>/customer/loginView.do">로그인</a></li>
				</ul>
			<%}else {%>
				<!-- 로그인 후 메뉴(우측부터) : 고객센터, 로그아웃, 정보 수정, 고객 이름 -->
				<ul>
					<li><a href="<%=conPath%>/fileboard/fboardList.do">고객센터</a></li>
					<li><a href="<%=conPath %>/customer/logout.do">로그아웃</a></li>
					<li><a href="<%=conPath %>/customer/modifyView.do">정보수정</a></li>
					<li><a href="#"><%=((MemberDto)session.getAttribute("member")).getMname() %></a></li>
				</ul>
			<%} %>
		</div>
		<div class="logo" onclick="location.href='<%=conPath%>/main/main.jsp'">
			<img src = "https://www.moel.go.kr/images/layout/img_footer_logo.png">
		</div>
		<div class="lnb">
			<!-- 우측부터 메뉴 : 도서보기, 도서등록(로그인후) -->
			<ul>
				<li><a href="<%=conPath%>/book/bookList.jsp">도서보기</a></li>
				<%if(session.getAttribute("member") != null) { %>
					<li><a href="<%=conPath%>/book/bookRegister.jsp">도서등록</a></li>
				<% } %>
			</ul>
		</div>	
	</header>
</body>
</html>