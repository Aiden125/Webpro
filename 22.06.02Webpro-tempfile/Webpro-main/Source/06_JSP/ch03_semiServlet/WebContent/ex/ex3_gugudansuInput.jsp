<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- 내가 있는 폴더의 루트라는것 표시 = ../ -->
	<!--  <link href="../css/ex3.css" rel="stylesheet"> -->
	<!-- <link href="http://localhost:8090/ch03_semiServlet/css/ex3.css" rel="stylesheet"> -->
	<link href="/ch03_semiServlet/css/ex3.css" rel="stylesheet">
</head>
<!--  ex3.jsp -> 파라미터를 가지고 Ex3서블릿에 요청 -->
<body>
	<!-- <form action="../Ex3"></form> -->
	<form action="/ch03_semiServlet/Ex3" method="get">
		<select name="su">
		<!-- selected는 기본적으로 나오게하는 메뉴
		     value 안넣으면 텍스트가 value로 잡힘 -->
			<option value="2">2단</option>
			<option value="3">3단</option>
			<option value="4">4단</option>
			<option value="5">5단</option>
			<option value="6">6단</option>
			<option value="7" selected="selected">7단</option>
			<option value="8">8단</option>
			<option value="9">9단</option>
		</select>
		<input type="submit" value="구구단출력">
	</form>
</body>
</html>