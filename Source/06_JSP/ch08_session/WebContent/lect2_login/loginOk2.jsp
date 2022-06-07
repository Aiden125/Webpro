<%@page import="java.net.URLEncoder"%>
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
	//id, pw파라미터 잡아와서 그에 맞는 대응해주기
	String msg = "";
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	//유효한 id인 경우, 유효하지 않은 경우
	if(id!=null && id.equals("aaa")){ //유효한 id를 입력한 경우
		if(pw!=null && pw.equals("111")){ //pw가 맞는 경우
			// 로그인 처리 = 세션 속성(id, name) 추가한 후 welcome.jsp로 가기
			session.setAttribute("id", id);
			session.setAttribute("name", "홍길동");
			response.sendRedirect("welcome.jsp");
			
	}else{ // id는 맞지만 pw가 틀린 경우
		out.println("<script>");
		out.println("alert('pw를 체크하세요')");
		out.println("history.back()");
		out.println("</script>");
		}
	}else{ // 유효하지 않는 id를 입력한 경우
		out.println("<script>");
		out.println("alert('id를 체크하세요')");
		out.println("history.back()");
		out.println("</script>");
	}
%>	
</body>
</html>