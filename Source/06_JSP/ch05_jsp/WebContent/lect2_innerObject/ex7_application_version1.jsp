<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
			<!-- 경로에 대한 내부객체 모음집 (내부객체라고 해야되는게 맞나?) -->
			<!-- 한번 읽을 때 여러바이트씩 읽는 애들을 출력해보기.(스트림객체) -->
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
	String conPath = request.getContextPath();
	String appPath = application.getContextPath(); // ch05_jsp
	String absolutePath = application.getRealPath("."); //현재 프로젝트 절대경로
%>
	<h2 style="color:green">conPath : <%=conPath %></h2>
	<h2 style="color:red">appPath : <%=appPath %></h2>
	<h2 style="color:blue">absolutePath : <%=absolutePath %></h2>
	
<%
	String filePath = application.getRealPath("WEB-INF/input.txt"); //파일의 절대경로
	out.println(filePath + "(filePath)의 내용<br><br>");
	
	//스트림 객체생성(파일열기) - 읽는다 - 스트림객체닫기(파일닫기)
	//1. 객체생성(파일이 없을수도 있기에 트라이캐치문으로 잡아줘야한다.)
	//2. 읽기(while문). 만약 끝부분이어서 null이면 break;
	//3. 닫아주기.(finally로) try-catch로 br이 null 아니라면 닫아주기.
	
	//Bufferd는 한줄씩 읽기위함
	BufferedReader br = null;
	try{
		br = new BufferedReader(new FileReader(filePath)); // 스트림객체생성
		while(true){
			String line = br.readLine(); //파일 읽기(한줄씩). 파일의 끝이면 null리턴
			if(line==null) break;
			out.println(line + "<br>");
		}
	}catch(Exception e){
		out.println("파일이 존재하지 않거나 읽을 수 없는 파일입니다.");
	}finally{
		try{
			if(br!=null) br.close();
		}catch(Exception e){
			
		}
	}
	
%>
</body>
</html>