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
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).ready(function(){

		});
		
		// javascript를 통해 행 클릭 시 상세보기
		function trclicked(bid){
			location.href='${conPath}/boardcontent.do?bid='+bid+'&pageNum=${pageNum}';			
		}
	</script>
</head>
<body>
	<c:if test="${writeResult eq 1}">
		<script>alert('글쓰기 성공');</script>	
	</c:if>

	<table>
		<tr>
			<td>
				<a href="${conPath }/writeView.do">글쓰기</a>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<th>글번호</th><th>글쓴이</th><th>글제목</th><th>작성일</th><th>조회수</th>
		</tr>
		<c:if test="${totCnt eq 0 }">
			<td colspan="5">등록된 글이 없습니다</td>
		</c:if>
		<c:if test="${totCnt != 0 }">
			<c:forEach items="${boardList }" var="bDto">
				<tr onclick="trclicked(${bDto.bid})">
					<td>${bDto.bid }</td>
					<td>${bDto.bname }</td>
					<td class="left"> <!-- 들여쓰기 -->
						<c:forEach var="i" begin="1" end="${bDto.bindent }">
							<c:if test="${i == bDto.bindent }">
								└
							</c:if>
							<c:if test="${i != bDto.bindent }"> <!-- 들여쓰기가 남은 경우 -->
							 &nbsp; &nbsp; &nbsp;
							</c:if>
						</c:forEach>
						${bDto.btitle }
					</td>
					<td>
						<fmt:formatDate value="${bDto.bdate }" pattern="yy년MM월dd일(E)"/>
					</td>
					<td>
						<fmt:formatNumber value="${bDto.bhit }" groupingUsed="true"/>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		
	</table>
	<div class="paging">
		<c:if test="${paging.startPage > paging.blockSize }">
			[ <a href="${conPath }/boardList.do?pageNum=${paging.startPage-1}">이 전</a> ]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
			<c:if test="${i eq paging.currentPage }">
				[ <b> ${i } </b> ]
			</c:if>
			<c:if test="${i != paging.currentPage }">
				[ <a href="${conPath }/boardList.do?pageNum=${i}">${i }</a>]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
			[ <a href="${conPath }/boardList.do?pageNum=${paging.endPage+1}">다 음</a> ]
		</c:if>
	</div>
</body>
</html>