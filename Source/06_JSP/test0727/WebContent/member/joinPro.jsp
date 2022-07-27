<%@page import="java.sql.Date"%>
<%@page import="com.test.dao.MemberDao"%>
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
	<%request.setCharacterEncoding("utf-8");%>
	<jsp:useBean id="dto" class="com.test.dto.MemberDto"/>
	<jsp:setProperty name="dto" property="*" />
<%
	MemberDao dao = MemberDao.getInstance();
	int result = dao.join(dto);
	if(result == dao.SUCCESS){
%>
	<script>
		alert('회원등록 되었습니다.');
		location.href='list.jsp';
	</script>
		
<%	}else{
%>
	<script>
		alert('회원가입이 실패되었습니다.');
		history.back();
	</script>		
<% 	}
	
%>	
</body>
</html>