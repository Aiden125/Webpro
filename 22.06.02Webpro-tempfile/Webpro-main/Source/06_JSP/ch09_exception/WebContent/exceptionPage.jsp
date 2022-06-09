<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<%-- 200 : 정상상태 / 500 문법오류나 예외사항이 발생한 경우
	 404 : 해당문서를 찾을 수 없을 때
	 407 : 인증을 받지 못한 경우
--%>
<!--  에러 메시지를 관리자만 볼 수 있게 뿌려줘보자
1.script를 이용해 콘솔에 예외메시지 뿌리기(자바콘솔로도 뿌려도 상관없음)
2.맨 위에 에러페이지라고 선언해주기
3.response.setStatus(200)을 선언해주면서 에러를 200에러로 바꿔주기(어떤 에러페이지든 200으로 바꿔줌).
 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		console.log("예외 메시지 : " + "<%=exception.getMessage()%>');
		console.log("예외 타입 : " + "<%=exception.getClass().getName()%>');
	</script>
</head>
<body>
	<h1>공사중입니다. 0으로 나누는 부분은 아직 처리되지 않았습니다.</h1>
	<h6>문의 주시면 감사하겠습니다. mail 주소 추가</h6>

<%
	//자바로 출력 원하는 경우 이렇게
	System.out.println("예외 메시지 : " + exception.getMessage());
	System.out.println("예외 타입 : " + exception.getClass().getName());
%>
</body>
</html>