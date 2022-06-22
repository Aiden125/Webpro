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
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			
			// id check
			$('input[name="mid"]').keyup(function(){
				var mid = $('input[name="mid"]').val();
				
				$.ajax({
					url : '${conPath}/idCheck.do',
					data : 'mid='+mid,
					type : 'get',
					dataType : 'html',
					success : function(data){
						$('#idCheckResult').html(data);
					}
				});
			});
			
			// pw check
			$('input[name="mpw"], input[name="mpwChk"]').keyup(function(){
				var mPw = $('input[name="mpw"]').val();
				var mPwChk = $('input[name="mpwChk"]').val();
				if(mPw == mPwChk){
					$('#pwCheckResult').text('비밀번호 일치');
				}else{
					$('#pwCheckResult').html('<b>비밀번호 불일치</b');
				}
			});// pw check
			
			// email check
			$('input[name="memail"]').keyup(function(){
				var memail = $('input[name="memail"]').val();
				
				$.ajax({
					url : '${conPath}/emailCheck.do',
					data : 'memail='+memail,
					type : 'get',
					dataType : 'html',
					success : function(data){
						$('#emailCheckResult').html(data);
					}
				});
			});
			
			// 조건 부합x인 경우 가입 못하게
			$('form').submit(function(){
				var idCheckResult = $('#idCheckResult').text().trim();
				var pwCheckResult = $('#pwCheckResult').text().trim();
				var emailCheckResult = $('#emailCheckResult').text().trim();
				if(idCheckResult != '사용가능한 ID입니다'){
					alert('아이디를 확인하세요')
					$('#idCheckResult').focus();
					return false;
				}else if(pwCheckResult != '비밀번호 일치'){
					alert('비밀번호를 확인하세요')
					return false;
				}else if(emailCheckResult != '사용가능한 메일입니다'){
					alert('이메일을 확인해주세요')
					return false;
				}
			});
			
		});
	</script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  	<script>
	  $( function() {
	    $( "#datepicker" ).datepicker({
	    	dateFormat : 'yy-mm-dd',
	    	changeMonth : true, // 월을 바꿀 수 있는 셀렉트 박스 표시
	    	monthNamesShort : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    	showMonthAfterYear : true,
	    	yearSuffix : '년', // "2020년 3월"
	    	showOtherMonths : true,
	    	dayNamesMin:['일','월','화','수','목','금','토'],
				changeYear : true, // 년을 바꿀 수 있는 셀렉트 박스 표시
				minDate : '-100y', // 현재 날짜로부터 100년 이전까지 표시
				yearRange : 'c-100:c+0', // 년도 선택 셀렉트 
	    });
	  } );
  </script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<form action="${conPath }/join.do" method="post" enctype="multipart/form-data">
		<table>
			<caption>회원가입</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid" required="required">
				<div id="idCheckResult"> &nbsp; </div></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="mpw" required="required"></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" name="mpwChk" required="required">
					<div id="pwCheckResult"> &nbsp; </div></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mname" required="required"></td>
			</tr>
			<tr>
				<th>메일</th>
				<td><input type="email" name="memail">
				<div id="emailCheckResult"> &nbsp; </div></td>
			</tr>
			<tr>
				<th>사진</th>
				<td><input type="file" name="mPhoto"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="mbirth" id="datepicker"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="email" name="maddress"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="회원가입" class="btn">
					<input type="button" value="로그인" class="btn" onclick="location.href='${conPath}/loginView.do'">
				</td>
			</tr>
		</table>	
	</form>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>