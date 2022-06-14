<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<form action=#>
		<input type="text" name="su1" value="<%=(int)(Math.random()*9+1) %>"> * 
		<input type="text" name="su2" value="<%=(int)(Math.random()*9+1) %>"> =
		<input type="number" name="result">
		<p><input type="submit" value="정답체크"></p>
	</form>
	
	${param.su1 } * ${param.su2 } = ${param.result }
	${param.su1 * param.su2 == param.result ? "는 true" : "는 false" }
	<!-- 입력안되었을 때는 안뿌리고 싶다면 -->
	${not empty param.result ? (param.su1*param.su2 eq param.result ? "정답" : "오답") : "" }
	
</body>
</html>