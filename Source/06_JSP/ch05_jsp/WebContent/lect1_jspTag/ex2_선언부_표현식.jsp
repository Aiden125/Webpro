<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

						<!-- 선언부에 대한 이해하기  -->
		
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
	int j=0;
	i++; j++;
	strBuf.append("<span>♡</span>");
	out.println("strBuf = " + strBuf+"<br>");
	out.println("sum(5,2) = " + sum(5,2) +"<br>");
%>

	전역변수 i = <%=i %><br>
	지역변수 j = <%=j %><br>

<%! //선언부에는 전역변수 및 메소드 선언. 밑에 선언해도 가장먼저 읽음
	//지역변수는 새로 생기면 계속 초기화, 전역변수는 메모리가 떠 있는 동안 계속 떠 있음
	int i; // 0으로 초기화
	StringBuffer strBuf = new StringBuffer("Good ");
	public int sum(int a, int b){
		return a+b;
	}
%>	
</body>
</html>