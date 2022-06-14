<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- if태그에서는 else가 없다? 따라서 그 정반대 조건도 걸어줘야한다.-->
	<!-- if태그에서 변수를 넣으면 결과값(true or false가 담긴다) -->
	<c:if test="${1+2 eq 3 }">
		1+2는 3이지<br>
	</c:if>
	<c:if test="${1+2 != 3 }" var="result" scope="page">
		1+2는 3이 아니지<br>
	</c:if>
	두번째 if문 조건에 대한 결과는 ${result } 입니다

<%--
	if(1+2==3){
		out.println("1+2는 3이지");
	}else{
		out.println("아니지");
	}
--%>
</body>
</html>