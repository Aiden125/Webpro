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
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<table>
		<caption>상세보기</caption>
		<tr>
			<th colspan="2">상대MBTI</th>
			<td colspan="2">${contentView.bmbti }</td>
			<th colspan="2">작성자</th>
			<td colspan="2">${contentView.mname }</td>
		</tr>
		<tr>
			<th colspan="8">${contentView.btitle }</th>
		</tr>
		<tr>
			<th colspan="8">${contentView.bcontent }</th>
		</tr>
		<tr>
			<th colspan="8">${contentView.bfilename }</th>
		</tr>
		<tr>
			<td colspan="2">글번호</td><td colspan="2">${contentView.bno }</td>
			<td colspan="2">작성일</td><td colspan="2">${contentView.brdate }</td>
		</tr>
		<tr>
			<td colspan="2">조회수</td><td colspan="2">${contentView.bhit }</td>
			<td colspan="2">좋아요</td><td colspan="2">${contentView.blike }</td>		
		</tr>
		<tr>
			<td colspan="8">
				<button onclick="location.href='${conPath}/modify_view.do?bid=${param.bid }&pageNum=${param.pageNum }'">수정</button>
				<button onclick="location.href='${conPath}/delete.do?bid=${param.bid }&pageNum=${param.pageNum }'">삭제</button>
				<button onclick="location.href='${conPath}/reply_view.do?bid=${param.bid }&pageNum=${param.pageNum }'">답변</button>
				<button onclick="location.href='${conPath}/list.do?pageNum=${param.pageNum }'">목록</button>
			</td>
		</tr>
	</table>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>