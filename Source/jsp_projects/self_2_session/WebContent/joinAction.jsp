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
	
	//�Է¾ȵ� ������ �ִ°��
	if(name==null || id==null || pw==null || pwChk==null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('�Է¾ȵ� ������ �ֽ��ϴ�.')");
		script.println("history.back()");
		script.println("<script>");
	}
	//id�� �ߺ��Ǵ� ���
	if(id.equals("aaa")){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('�̹� �����ϴ� ���̵��Դϴ�.')");
		script.println("history.back()");
		script.println("<script>");
	}
	//���� ���� ���
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("location.href=main.jsp");
	script.println("<script>");
%>
</body>
</html>