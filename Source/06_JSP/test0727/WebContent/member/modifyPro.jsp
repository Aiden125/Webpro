<%@page import="com.test.dao.MemberDao"%>
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
	<%request.setCharacterEncoding("utf-8");%>
	<jsp:useBean id="dto" class="com.test.dto.MemberDto"/>
	<jsp:setProperty name="dto" property="*" />
<%
	MemberDao dao = MemberDao.getInstance();
	int result = dao.modify(dto);
	if(result == dao.SUCCESS){
%>
	<script>
		alert('회원정보가 수정되었습니다.');
		location.href='../member/list.jsp';
	</script>
<%		
	}else{
%>
	<script>
		alert('수정 실패했습니다.');
		history.back();
	</script>
<%
	}
	
%>
</body>
</html>