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
				/* jquery를 이용하는 방법
				$('tr').click(function(){
				var bid = Number($(this).children().eq(2).text());
				if(!isNaN(bid)){
					alert(bid); 
					location.href='${conPath}/mvcboard/content.do?bid='+bid+'&pageNum=${pageNum}';
				}
			});
			*/
		});
		
		// javascript를 통한 방법
		function trclicked(bid){
			location.href='${conPath}/mvcboard/content.do?bid='+bid+'&pageNum=${pageNum}';			
		}
	</script>
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	
	<!-- 글쓰기 성공 / 실패 alert -->
	<c:if test="${writeResult eq SUCCESS }">
		<script>
			alert('글쓰기 성공');
		</script>
	</c:if>
	<c:if test="${writeResult eq FAIL }">
		<script>
			alert('글쓰기 실패');
		</script>
	</c:if>
	<!-- 글수정 성공 / 실패 alert -->
	<!-- 글삭제 성공 / 실패 alert -->
	<!-- 글답변 성공 / 실패 alert -->
	<c:set var="oNum" value="${orderNum }"/> <!-- 변수명 약간 다르게 -->
	<c:set var="iNum" value="${inverseNum }"/>
	<table>
		<tr>
			<td>
				<a href="${conPath }/mvcboard/writeView.do">글쓰기</a>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<th>순번</th><th>역순</th><th>글번호</th><th>글쓴이</th><th>글제목</th><th>작성일</th><th>조회수</th>
		</tr>
		<c:if test="${totCnt eq 0 }">
			<td colspan="7">등록된 글이 없습니다</td>
		</c:if>
		<c:if test="${totCnt != 0 }">
			<c:forEach items="${boardList }" var="bDto">
				<tr onclick="trclicked(${bDto.bid})">
					<td>${oNum }</td> <!-- dto에 없는 항목이기 때문에 -->
					<td>${iNum }</td> <!-- dto에 없는 항목이기 때문에 -->
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
						<fmt:formatDate value="${bDto.bdate }" pattern="yy/MM/dd(E) hh:mm:ss(a)"/>
						<%-- <fmt:formatDate value="${bDto.date }" pattern="yy/MM/dd(E) hh:mm:ss(a)"/> --%>
					</td>
					<td>
						<fmt:formatNumber value="${bDto.bhit }" groupingUsed="true"/>
					</td>
				</tr>
				<c:set var="oNum" value="${oNum + 1 }"/>
				<c:set var="iNum" value="${iNum - 1 }"/>
			</c:forEach>
		</c:if>
		
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			[ <a href="${conPath }/mvcboard/list.do?pageNum=${startPage-1}">이 전</a> ]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				[ <b> ${i } </b> ]
			</c:if>
			<c:if test="${i != pageNum }">
				[ <a href="${conPath }/mvcboard/list.do?pageNum=${i}">${i }</a>]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			[ <a href="${conPath }/mvcboard/list.do?pageNum=${endPage+1}">다 음</a> ]
		</c:if>
	</div>
</body>
</html>