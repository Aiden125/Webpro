<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
		<%
		String name = (String)session.getAttribute("name");
		String id = (String)session.getAttribute("id");
		if(id==null && name==null){ //로그인 전 메뉴
		%>
		<button onclick="location.href='join.jsp'">회원가입</button>
		<button onclick="location.href='login.jsp'">로그인</button>
			<p>방문해주셔서 감사합니다.</p>
		<% 
		}else{ //로그인 후 메뉴
		%>
		<button onclick="location.href='#'">정보수정</button>
		<button onclick="location.href='#'">글작성</button>
		<button onclick="location.href='logoutAction.jsp'">로그아웃</button>
			<p>방문해주셔서 감사합니다.<%=id %>님</p>
		<%
		}
		%>
</body>
</html>