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
		<tr>
			<td colspan="8" style="text-align:right"><b>상대MBTI :</b> ${contentView.bmbti }<br>
													<b>작성자 :</b> ${contentView.mname }</td>
		</tr>
		<tr>
			<td colspan="8" style="text-align:left; font-size:1.5em;">${contentView.btitle }</td>
		</tr>
		<tr>
			<td colspan="8" style="height: 200px; text-align: left;">${contentView.bcontent }</td>
		</tr>
		<tr>
			<th colspan="8">${contentView.bfilename }</th>
		</tr>
		<tr>
		</tr>
		<tr>
			<td colspan="8" style="text-align:right;">
			조회수 : ${contentView.bhit }<br>
			작성일 : ${contentView.brdate }
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:left;">
			<a href="${conPath }/freeBoardLike.do?bno=${param.bno }&pageNum=${param.pageNum }">좋아요 : </a>${contentView.blike }
			</td>
			<td colspan="6" style="text-align:right;">
				<button class="btn btn-primary" onclick="location.href='${conPath}/freeBoardModifyView.do?bno=${param.bno }&pageNum=${param.pageNum }'">수정</button>
				<button class="btn btn-primary" onclick="location.href='${conPath}/freeBoardDelete.do?bno=${param.bno }&pageNum=${param.pageNum }'">삭제</button>
				<button class="btn btn-primary" onclick="location.href='${conPath}/reply_view.do?bid=${param.bno }&pageNum=${param.pageNum }'">답변</button>
				<button class="btn btn-primary" onclick="location.href='${conPath}/freeBoardListView.do?pageNum=${param.pageNum }'">글목록</button>
			</td>
		</tr>
	</table>
<div class="card text-white bg-secondary my-5 py-4 text-center">
<div class="card-body"><p class="text-white m-0"></p></div>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>