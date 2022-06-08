<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<%=conPath %>/css/join.css' rel='stylesheet'>
<script>
	function chkJoinInfo(){
		if(frmJoin.cpw.value!=frmJoin.cpwChk.value){
			alert('비밀번호를 확인하세요');
			frmJoin.cpw.value = '';
			frmJoin.cpwChk.value = '';
			frmJoin.cpw.focus();
			return false;
		} 
	}
</script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="joinForm_wrap">
		<form action="joinPro.jsp" method="post" name="frmJoin" onsubmit="return chkJoinInfo()">
			<div id="join_title">회원가입</div>
			<table>
				<tr>
					<th><label for="cid">아이디</label></th>
					<td><input type="text" name="cid" id="cid" class="cid" required="required" autofocus="autofocus"></td>
				</tr>
				<tr>
					<th><label for="cpw">비밀번호</label></th>
					<td><input type="password" name="cpw" id="cpw" class="cpw" required="required"></td>
				</tr>
				<tr>
					<th><label for="cpwChk">비밀번호확인</label></th>
					<td><input type="password" name="cpwChk" id="cpwChk" class="cpwChk"></td>
				</tr>
				<tr>
					<th><label for="cname">이름</label></th>
					<td><input type="text" name="cname" id="cname" class="cname" required="required"></td>
				</tr>
				<tr>
					<th><label for="ctel">전화</label></th>
					<td><input type="text" name="ctel" id="ctel" class="ctel" required="required" placeholder="010-"></td>
				</tr>
				<tr>
					<th><label for="cemail">이메일</label></th>
					<td><input type="email" name="cemail" id="cemail" class="cemail" placeholder="(선택사항)"></td>
				</tr>
				<tr>
					<th><label for="caddress">주소</label></th>
					<td><input type="text" name="caddress" id="caddress" class="caddress" placeholder="(선택사항)"></td>
				</tr>
				<tr>
					<th><label for="tempbirth">생년월일</label></th>
					<td><input type="date" name="tempbirth" id="tempbirth" class="tempbirth" placeholder="년도-월-일" required="required"></td>
				</tr>

				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="cgender" value="m" checked="checked" id="m"><label for="m">남자</label>
						<input type="radio" name="cgender" value="f" id="f"><label for="f">여자</label>
					</td>
				</tr>
				<tr>
					<td colspan="2"> </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기" class="joinBtn_style">
						<input type="reset" value="다시하기" class="joinBtn_style">
						<input type="button" value="로그인" class="joinBtn_style" 
											onclick="location.href='login.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>
