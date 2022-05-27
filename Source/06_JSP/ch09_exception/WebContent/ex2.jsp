<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>

<!-- 일부러 에러를 유발해서 대처해보자  500에러 유발시킬 페이지 -->

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>web.xml을 이용한 예외페이지 처리</h2>
	<a href="xx.html">없는 파일 누르면 404에러</a>
	
<%
	//int param = Integer.parseInt(request.getParameter("param")); //NumberFormatException
	int[] arr = {10,20,30};
	for(int i=0; i <= arr.length; i++){ // ArrayIndexOutOfBoundseException
		out.print(arr[i] + ", ");
	}
%>
</body>
</html>