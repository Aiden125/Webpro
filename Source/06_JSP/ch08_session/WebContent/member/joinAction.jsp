<%@page import="java.sql.Date"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Arrays"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet">
	<link href="<%=conPath %>/css/footer.css" rel="stylesheet">
</head>
<body>
<% 
	request.setCharacterEncoding("UTF-8");
	String hiddenParam  = request.getParameter("hiddenParam");
	String name 		= request.getParameter("name");
	String id 			= request.getParameter("id");
	String pw 			= request.getParameter("pw");
	String birth 		= request.getParameter("birth");
	Date birth2=null;
	Timestamp birth3=null;
	if(birth!="") {
		birth2			= Date.valueOf(request.getParameter("birth"));
		birth3	= Timestamp.valueOf(request.getParameter("birth") + " 00:00:00"); //날짜만 오면 안되고 시간도 같이 와야하기에 00 부분 추가해줌
	}
	Date date		= new Date(System.currentTimeMillis());
	String[] hobby		= request.getParameterValues("hobby");
	String gender		= request.getParameter("gender");
	String email 		= request.getParameter("email");
	String[] mailSend 	= request.getParameterValues("mailSend");
	session.setAttribute("id", id);

%>		
	<jsp:include page="header.jsp"/>
	<div id="joinForm_wrap">
<div id="join_title">회원가입정보</div>
	<table>
		<tr>
			<th>name : </th>
			<th><%=name %> </th>					
		</tr>
		<tr>
			<th>id : </th>
			<th><%=id %> </th>					
		</tr>
		<tr>
			<th>pw : </th>
			<th><% for(int i=0; i<pw.length(); i++) {
				out.println('*');
			} %> </th>					
		</tr>
		<tr>
			<th>birth2 : </th>
			<th><%=birth3 %> </th>					
		</tr>
		<tr>
			<th>hobby : </th>
			<th><% if(hobby!=null) {
				for(int i=0; i<hobby.length; i++) {
					if(i == hobby.length-1) {
						out.println(hobby[i]);
					}else {
						out.println(hobby[i] + ", ");
					}
				}
			}else {
				out.println("선택된 취미가 없음");
			}
				 %> </th>					
		</tr>
		<tr>
			<th>gender : </th>
			<th><%=gender %> </th>					
		</tr>
		<tr>
			<th>email : </th>
			<th><%=email %> </th>					
		</tr>
		<tr>
			<th>mailSend : </th>
			<th><%if(mailSend!=null) {
				for(int i=0; i<mailSend.length; i++) {
					if(i == mailSend.length-1) {
						out.println(mailSend[i]);
					}else {
						out.println(mailSend[i] + ", ");
					}
				}
			}else {
				out.println("메일 수신 안함");
			}  %> </th>					
		</tr>
		
	</table>
	</div>
<jsp:include page="footer.jsp"/>

</body>
</html>