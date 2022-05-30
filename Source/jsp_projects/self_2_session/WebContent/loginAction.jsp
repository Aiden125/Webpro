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
	
	//id, pw 문제 없는 경우
	if(id!=null && id.equals("aaa")){
		if(pw!=null && pw.equals("111")){
			PrintWriter script = response.getWriter();
			session.setAttribute("id", id);
			session.setAttribute("name", "홍길동");
			script.println("<script>");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		}else {//pw가 틀린경우
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('pw를 확인해주세요')");
			script.println("history.back()");
			script.println("</script>");
		}
	}else{//id가 틀린경우
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('id를 확인해주세요')");
		script.println("history.back()");
		script.println("</script>");
	}
%>
</body>
</html>