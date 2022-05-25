<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>Hello, World</h1>
	<%//이 양끝의 마크는 '스크립 트릿'이라고 하는데, 여기안에는 자바 형식을 넣는다
	int total = 0;
	for(int i=1 ; i<=100; i++){
		total += i;
	}
	%>
	<h2>1부터 100까지 누적합은 <%=total%>입니다</h2>
</body>
</html>