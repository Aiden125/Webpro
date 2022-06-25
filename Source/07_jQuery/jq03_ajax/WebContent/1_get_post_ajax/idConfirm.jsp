<%@page import="com.lec.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
<% // idConfirm.jsp?mId=aaa
	String mId = request.getParameter("mId");
	MemberDao mDao = MemberDao.getInstance();
	int result = mDao.checkId(mId);
	if(result == MemberDao.FAIL){
		out.print("중복된 아이디입니다");
	}else{
		out.print("사용 가능한 ID입니다");
	}
%>
</body>
</html>