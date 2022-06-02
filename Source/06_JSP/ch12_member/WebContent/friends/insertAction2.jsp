<%@page import="com.lec.friends.FriendsDao"%>
<%@page import="com.lec.friends.FriendsDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
	<jsp:useBean id="dto" class="com.lec.friends.FriendsDto" scope="page"/>
	<jsp:setProperty name="dto" property="*"/>
	
<%
	FriendsDao fDao = new FriendsDao();
	int result = fDao.insertFriends(dto);
	if(result == FriendsDao.SUCCESS){
		out.println("<script>");
		out.println("alert('친구추가 되었습니다.')");
		out.println("location.href='view2.jsp'");
		out.println("</script>");
	}else{ //회원가입 실패(DB오류)
		out.println("<script>");
		out.println("alert('회원가입 실패되었습니다.')");
		out.println("history.back()");
		out.println("</script>");	
	}
	
	
%>
</body>
</html>