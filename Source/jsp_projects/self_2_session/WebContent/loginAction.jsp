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
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	//id, pw ���� ���� ���
	if(id!=null && id.equals("aaa")){
		if(pw!=null && pw.equals("111")){
			PrintWriter script = response.getWriter();
			session.setAttribute("id", id);
			session.setAttribute("name", "ȫ�浿");
			script.println("<script>");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		}else {//pw�� Ʋ�����
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('pw�� Ȯ�����ּ���')");
			script.println("history.back()");
			script.println("</script>");
		}
	}else{//id�� Ʋ�����
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('id�� Ȯ�����ּ���')");
		script.println("history.back()");
		script.println("</script>");
	}
%>
</body>
</html>