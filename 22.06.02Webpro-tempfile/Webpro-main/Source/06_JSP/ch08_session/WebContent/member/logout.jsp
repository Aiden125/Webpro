<%@page import="java.util.TimerTask"%>
<%@page import="java.util.Timer"%>
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
		width:600px;
		margin:0 auto;
		height:600px;
		line-height:600px;
		text-align: center;
		font-size: 1.5em;
		font-weight: bold;
		color:#A47160;
	}
	</style>


<script>
setTimeout(function (){	
	location.href="<%=conPath%>/member/main.jsp"	
	},2000);
</script>

</head>
<body>
<%
	String name = (String)session.getAttribute("name");
	if(name!=null){
		session.invalidate(); //한번에 지우기
	}
%>
<jsp:include page="header.jsp"/>
	<div id="logoutForm_wrap">
	
		<p>로그아웃되었습니다. 2초후 페이지 이동됩니다.</p> 
	</div>	
	<jsp:include page="footer.jsp"/>
	
</body>
</html>