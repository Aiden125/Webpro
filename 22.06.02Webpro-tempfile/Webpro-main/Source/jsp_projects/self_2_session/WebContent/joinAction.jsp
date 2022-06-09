<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String pwChk = request.getParameter("pwChk");
	
	//입력안된 사항이 있는경우
	if(name==null || id==null || pw==null || pwChk==null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력안된 사항이 있습니다.')");
		script.println("history.back()");
		script.println("<script>");
	}
	//id가 중복되는 경우
	if(id.equals("aaa")){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 존재하는 아이디입니다.')");
		script.println("history.back()");
		script.println("<script>");
	}
	//문제 없는 경우
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("location.href=main.jsp");
	script.println("<script>");
%>
</body>
</html>