<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="java.sql.Date"%>
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
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
		String tempbirth = request.getParameter("tempbirth");
		if(!tempbirth.equals("")){
			dto.setCbirth(Date.valueOf(tempbirth));
		}
		
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		String sessionPw = null;
		if(customer!=null){ //로그인이 된 상태라면
			sessionPw = customer.getCpw();
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionPw.equals(oldPw)){ //수정창에서 현재 비번을 맞게 입력한경우
			if(dto.getCpw()==null){ // 새로운 비밀번호가 입력됐다면
				dto.setCpw(sessionPw);
			}
			CustomerDao cDao = CustomerDao.getInstance();
			int result = cDao.modifyCustomer(dto);
			if(result == CustomerDao.SUCCES){ // 정보수정 성공
				session.setAttribute("customer", dto);
				out.println("<script>");
				out.println("alert('회원정보 수정이 완료되었습니다.')");
				out.println("location.href='main.jsp'");			
				out.println("</script>");
			}else{ // 정보가 너무 긴 경우(DB오류)
				out.println("<script>");
				out.println("alert('회원정보 수정이 실패했습니다. 정보가 너무 깁니다')");
				out.println("history.back()");			
				out.println("</script>");
			}
		}else{ // 현재 비번이 틀린 경우
			out.println("<script>");
			out.println("alert('현재 비밀번호가 틀립니다.')");
			out.println("history.back()");			
			out.println("</script>");
		}
	%>
</body>
</html>