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
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h2>예외처리</h2>
	<c:catch var="error"> <!-- catch절에서 var를 선언하면 예외타입과 메시지가 변수에 저장됨 -->
		<h2>테스트</h2>
		<%=8/0 %>
		<p>기존은 예외가 발생되면 즉시 멈추고 그 밑에가 실행되지 않으나,
		catch로 감싸면 즉시 catch절을 빠져나가고 나머지를 실행함</p>
	</c:catch>
	예외 타입과 예외메시지 : <c:out value="${error }" default="예외발생 안됨"/>
</body>
</html>