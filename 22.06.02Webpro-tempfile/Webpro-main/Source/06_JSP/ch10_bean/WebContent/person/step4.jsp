<%@page import="com.lec.ex.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>

<!-- request는 새로운 요청(url이 바뀌는)게 있을 때까지만 실행 하는 것 -->

<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<!-- 프로세스단 -->
	<jsp:useBean class="com.lec.ex.Person" id="p" scope="request"/>
	<jsp:setProperty name="p" property="name" value='<%=request.getParameter("name") %>'/>
	<jsp:setProperty name="p" property="age"
							value='<%=Integer.parseInt(request.getParameter("age")) %>'/>
	<jsp:setProperty name="p" property="gender"
							value='<%=request.getParameter("gender").charAt(0) %>'/>
	<jsp:setProperty name="p" property="address"
							value='<%=request.getParameter("address") %>'/>
	<jsp:forward page="pView.jsp"/>
</body>
</html>