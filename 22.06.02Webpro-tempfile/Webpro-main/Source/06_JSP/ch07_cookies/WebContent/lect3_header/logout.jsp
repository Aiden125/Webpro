<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	#logoutForm_wrap{
		width:430px;
		margin:0 auto;
		height:600px;
		line-height:600px;
		text-align: center;
		font-size: 1.5em;
		font-weight: bold;
		color:#A47160;
	}
	</style>
</head>
<body>

<%
	Cookie[] cs = request.getCookies();
	if(cs!=null){
		for(Cookie c : cs){
			if(c.getName().equals("id")){
				c.setMaxAge(0);
				response.addCookie(c);
				break;
			}//if
		}//for
	}//if
	response.sendRedirect("main.jsp");
%>


</body>
</html>