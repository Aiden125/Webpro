<%@page import="java.net.URLEncoder"%>
<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="com.lec.customer.CustomerDao"%>
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
	request.setCharacterEncoding("utf-8");
	String msg = "";
	String cid = request.getParameter("cid");
	String cpw = request.getParameter("cpw");
	
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.loginCustomer(cid, cpw);
	
	if(result == CustomerDao.LOGIN_SUCCESS){ // 로그인 성공
		CustomerDto customer = cDao.getCustomer(cid);
		session.setAttribute("customer", customer);
		response.sendRedirect("main.jsp");
	}else{ // 로그인 실패
		msg = URLEncoder.encode("아이디 혹은 패스워드를 체크하세요", "utf-8");
		response.sendRedirect("login.jsp?msg="+msg);
	}
%>
</body>
</html>