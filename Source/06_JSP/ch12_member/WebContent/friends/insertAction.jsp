<%@page import="com.lec.friends.FriendsDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friends.FriendsDao"%>
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
	FriendsDao Dao = FriendsDao.getInstance();
	ArrayList<FriendsDto> dtos = Dao.friendsAll();
	
%>
</body>
</html>