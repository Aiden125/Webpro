<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
	boolean ok = false;
	String msg = "";
	request.setCharacterEncoding("utf-8"); //id에 한글도 넣고 싶다 할 경우 넣기.
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if(id!=null && id.equals("aaa")){
		if(pw!=null && pw.equals("111")){
			ok=true;
		}else{
			msg = "check the PW";
		}
	}else{
		msg = "check the ID";
	}
	if(!ok){
		//msg를 보내면서 로그인으로 보내기 id를 틀리면 msg에 id관련 문자가 날라가고, pw면 pw관련 문자가 날라감
		//DB연동하고 이 방식으로 하기로.
		response.sendRedirect("login.jsp?msg="+msg); 
	}
	%>

</body>
</html>