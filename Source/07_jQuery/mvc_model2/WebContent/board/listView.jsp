<%@page import="com.lec.dto.MemberDto"%>
<%@page import="com.lec.dao.MemberDao"%>
<%@page import="java.util.ArrayList"%>
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
			$('.tr').click(function(){
				var no = $(this).children().eq(0).text();
				if(!isNaN(Number(no))){
					location.href= '${conPath }/fContentView.do?fid=${dto.fid }&pageNum=${pageNum }';
				}
			});
		});
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<table>
		<caption>게시판</caption>
		<tr>
			<c:if test="${empty member }">
			<td>로그인을 하셔야 글쓰기를 하실 수 있습니다.</td>
			</c:if>
			
			<c:if test="${not empty member }">
			<td><a href="${conPath }/fWriteView.do">글쓰기</a></td>
			</c:if>
		</tr>
		
	</table>
	<table>
		<tr class="tr">
			<th>글번호</th><th>작성자</th><th>글제목</th><th>조회수</th><th>날짜</th><th>IP</th>
			<c:if test="${list.size() eq 0 }">
				<tr><td colspan="6">해당 페이지 글이 없습니다</td></tr>
			</c:if>
			<c:if test="${list.size() != 0 }">
				<c:forEach var="dto" items="${list }">
					<tr class="tr">
						<td>${dto.fid }</td>
						<td>${dto.mname }</td>
						
						<!-- 글제목 -->
						<td class="left">
						
							<!-- 답변글 들여쓰기 -->
							<c:forEach var="i" begin="1" end="${dto.findent }">
								<c:if test="${i eq dto.findent }">
									└
								</c:if>
								<c:if test="${i != dto.findent }">
									&nbsp; &nbsp;
								</c:if>
							</c:forEach>
							<a href="${conPath }/fContentView.do?fid=${dto.fid }&pageNum=${pageNum }">
							${dto.ftitle }</a>
							
							<!-- 조회수 10이상이면 * 넣기 -->
							<c:if test="${dto.fhit >= 10 }">
								<b> * </b>
							</c:if>
						</td> 
						<td>${dto.fhit }</td>
						<td><fmt:formatDate value="${dto.frdate }" pattern="yy년MM월dd일(E)"/></td>
						<td>${dto.fip }</td>
					</tr>
				</c:forEach>
			</c:if>
		</tr>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			[ <a href="${conPath }/fListView.do?pageNum=${startPage-1 }">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				[ <b> ${i } </b> ]
			</c:if>
			<c:if test="${i != pageNum }">
				[ <a href="${conPath }/fListView.do?pageNum=${i}">${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			[ <a href="${conPath }/fListView.do?pageNum=${endPage + 1 }">다음</a> ]
		</c:if>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>