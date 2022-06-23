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
	<c:if test="${empty member }">
		<script>
			alert('로그인 해주세요');
			location.href="${conPath}/loginView.do";
		</script>
	</c:if>
	<form action="${conPath }/modify.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="dbmphoto" value="${member.mphoto }">
		<table>
			<caption>회원정보수정</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid" value="${member.mid }" readonly="readonly"></td>	
				<td rowspan="4"><img src="${conPath }/memberPhotoUp/${member.mphoto}" width="100"></td>	
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="mpw" value="${member.mpw }"></td>		
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mname" value="${member.mname }"></td>		
			</tr>
			<tr>
				<th>메일</th>
				<td><input type="email" name="memail" value="${member.memail }"></td>
			</tr>
			<tr>
				<th>사진</th>
				<td colspan="2"><input type="file" name="mphoto"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td colspan="2"><input type="date" name="mbirth" value="${member.mbirth }"></td>		
			</tr>
			<tr>
				<th>주소</th>
				<td colspan="2"><input type="text" name="madderess" value="${member.maddress }"></td>		
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="정보수정" class="btn">
					<input type="reset" value="초기화" class="btn">
					<input type="button" value="이전" class="btn" onclick="history.back()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>