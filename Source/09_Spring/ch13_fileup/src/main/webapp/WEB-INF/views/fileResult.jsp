<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
	<h2>파일 업로드 결과 : ${fileResult }</h2>
	<p>file1 : ${filenames[0] }	</p>
	<p>file2 : ${filenames[1] }	</p>
	<p>file3 : ${filenames[2] }	</p>
	
	<!-- 파일 첨부 했을 때만 이미지 뿌려주기 -->
	<c:if test="${not empty filenames[0] }">
		<img src="upload/${filenames[0] }">
	</c:if>
	<c:if test="${empty filenames[0] }">
		<p>첫번째 첨부파일 첨부 안함</p>
	</c:if>
	
	<c:if test="${not empty filenames[1] }">
		<img src="upload/${filenames[1] }">
	</c:if>
	<c:if test="${empty filenames[1] }">
		<p>두번째 첨부파일 첨부 안함</p>
	</c:if>
	
	<c:if test="${not empty filenames[2] }">
		<img src="upload/${filenames[2] }">
	</c:if>
	<c:if test="${empty filenames[2] }">
		<p>세번째 첨부파일 첨부 안함</p>
	</c:if>
</body>
</html>