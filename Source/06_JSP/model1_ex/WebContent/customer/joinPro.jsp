<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="java.sql.Date"%>
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
%>
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto" scope="page"/>
	<jsp:setProperty name="dto" property="*"/>

<%	
	String tempbirth = request.getParameter("tempbirth");
	if(!tempbirth.equals("")){
		dto.setCbirth(Date.valueOf(tempbirth));
	}
	
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.confirmCid(dto.getCid()); // ID 중복체크
	
	if(result == CustomerDao.CUSTOMER_NONEXISTENT){ // ID 사용가능하다면
		result = cDao.insertCustomer(dto); // 회원가입
		if(result == CustomerDao.SUCCESS){ // 회원가입 성공
			session.setAttribute("cid", dto.getCid()); //id세션 값 주기
			out.println("<script>");
			out.println("alert('회원가입에 성공했습니다. 로그인 후 서비스를 이용하세요')");
			out.println("location.href='loginForm.jsp'");
			out.println("</script>");
		}else{ //회원가입 실패(DB오류)
			out.println("<script>");
			out.println("alert('회원가입 실패되었습니다. 너무 긴 데이터는 입력 불가합니다')");
			out.println("history.back()");
			out.println("</script>");
		}
	}else{ //사용 불가(이미 아이디가 존재)
		out.println("<script>");
		out.println("alert('중복된 ID입니다. 다른 아이디를 사용하세요')");
		out.println("history.back()");
		out.println("</script>");
	}
%>
</body>
</html>