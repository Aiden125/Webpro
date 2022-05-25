<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Arrays"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="join.css" rel="stylesheet">
	<link href="footer.css" rel="stylesheet">
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
%>		
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
			<th>birth : </th>
			<th><%=birth %> </th>					
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
		<tr>
			<th>가입일 : </th>
			<th><%=date %> </th>					
		</tr>
		<tr>
			<th>가입IP : </th>
			<th><%=request.getRemoteAddr() %> </th>					
		</tr>
		
	</table>
	</div>
	
	
	
	
	<footer>
		<div class="office_logo">
			<img src="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png">
		</div>
		<div class="office_address">
			<ul>
				<li>서울시 XX구 XX로 000 XXX빌딩 8F | TEL : 02-999-9999 | FAX : 02-999-9998</li>
				<li>사업자등록번호 : 000-12-00000 | 통신판매업신로 : 종로 제0000호 | 대표이사 : 홍길동</li>
				<li>좋은시스템 문의 메일 : webmaster@joeun.com</li>
			</ul>
		</div>
		<div class="copyright">
			ⓒ2022 JOEUNSYSTEM.Co.,Ltd. All Rights Reserved.
		</div>
	</footer>
</body>
</html>