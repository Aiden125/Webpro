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
	<h2>표현식 태그 이용</h2>
	<p>산술연산 : 10+1 = <%=10+1 %></p>
	<p>산술연산 : 10/0.0 = <%=10/0.0 %> <!-- 0.0으로 나누면 정말 매우매우 작은 수로 나눈거와 같다 -->
	<p>관계연산 : 1==2 => <%=1==2 %></p>
	<p>관계연산 : 1!=2 => <%=1!=2 %></p>
	<p>관계연산 : 1<2 => <%=1<2 %></p>
	<p>조건연산 : <%=(1>2)? "1이 2보다 큽니다." : "1이 2보다 크지 않습니다." %>
	<p>논리연산 : (1>2) || (1<2) = <%= (1>2) || (1<2) %></p>
	<p>로그인 여부 <%=session.getAttribute("customer")==null? "로그인 전" : "로그인 후"%></p>
	<p>로그인 여부 <%=session.getAttribute("customer")!=null? "로그인 전" : "로그인 후"%></p>
	<p>pageNum 파라미터 여부 <%=request.getParameter("pageNum")==null? "pageNum 안 옴":"pageNum 옴" %></p>
	<p>name 파라미터 : <%=request.getParameter("name") %>
	<%-- 	이건 파라미터가 안왔을 때 null이 들어오는데 null을 대문자로 바꿀 수는 없어서 오류남
	<p>name 파라미터를 대문자로 : <%=request.getParameter("name").toUpperCase() %> --%>
	
	<br><br><br>
	
	<h2>EL을 이용한 표기법(표현식 안에 쓸 수 있는 연산자 모두 사용 가능)</h2>
	<p>산술연산 : 10+1 = ${10+1 }</p>
	<p>산술연산 : 10/0.0 = ${10/0.0 } <!-- 0.0으로 나누면 정말 매우매우 작은 수로 나눈거와 같다 -->
	<p>관계연산 : 1==2 => ${1==2 }</p>
	<p>관계연산 : 1!=2 => ${1!=2 }</p>
	<p>관계연산 : 1<2 => ${1<2 }</p>
	<p>조건연산 : ${(1>2)? "1이 2보다 큽니다." : "1이 2보다 크지 않습니다." }</p>
	<p>논리연산 : (1>2) || (1<2) = ${ (1>2) || (1<2) }</p>
	<p>로그인 여부 ${empty customer ? "로그인 전" : "로그인 후" }</p>
	<p>로그인 여부 ${customer eq null ? "로그인 전" : "로그인 후" }</p>
	<p>로그인 여부 ${not empty customer ? "로그인 전" : "로그인 후" }</p>
	<p>pageNum 파라미터 여부 ${ param.pageNum ? "pageNum 안 옴":"pageNum 옴" }</p>
	<p>name 파라미터 : ${param.name }</p>
	<p>name 파라미터를 대문자로 : ${param.name.toUpperCase() }</p> <!-- 해당 파라미터가 없어도 오류x -->
	<%-- 	이건 파라미터가 안왔을 때 null이 들어오는데 null을 대문자로 바꿀 수는 없어서 오류남
	<p>name 파라미터를 대문자로 : <%=request.getParameter("name").toUpperCase() %> --%>
</body>
</html>