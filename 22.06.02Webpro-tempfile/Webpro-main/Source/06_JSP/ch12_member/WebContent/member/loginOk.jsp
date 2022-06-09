<%@page import="com.lec.member.MemberDto"%>
<%@page import="com.lec.member.MemberDao"%>
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
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	MemberDao mDao = MemberDao.getInstance();
	int result = mDao.loginCheck(id, pw);
	
	if(result==MemberDao.LOGIN_SUCCESS){ //로그인 성공
		MemberDto member = mDao.getMember(id); // ??
		session.setAttribute("member", member); // 멤버세션에 멤버라는걸 넣어주어 로그인했다는 증거만들기
		response.sendRedirect("main.jsp");
	}else if(result == MemberDao.LOGIN_FAIL_PW){ //비밀번호가 안맞을 때
		out.println("<script>");
		out.println("alert('비밀번호를 확인하세요')");
		out.println("history.back()");
		out.println("</script>");
	}else{ //아이디가 없을 때
		out.println("<script>");
		out.println("alert('존재하지 않는 아이디입니다')");
		out.println("history.back()");
		out.println("</script>");
	}
	
%>
</body>
</html>