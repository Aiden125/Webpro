<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="join.css" rel="stylesheet">
	<link href="footer.css" rel="stylesheet">
	<script>
		function chkJoin(){
			//두 비밀번호가 일치하게
			//취미를 반드시 1개 이상 선택하게
			
			if(frmJoin.pw.value!=frmJoin.pwChk.value){
				alert("비밀번호를 확인하세요");
				pw.value="";
				pwChk.value="";
				pw.focus();
				return false;
			}
			var hobbyCnt = 0;
			for(var i=0; i<frmJoin.hobby.length; i++){
				if(frmJoin.hobby[i].checked){
					hobbyCnt++;
				}
			}
			if(!hobbyCnt){
				alert("취미는 한 개 이상 선택하셔야합니다.");
				return false;
			}
		}
	</script>
</head>
<body>
	<div id="joinForm_wrap">
		<form action="joinPro.jsp" method="post" name="frmJoin" onsubmit="return chkJoin()">
			<div id="join_title">회원가입</div>
			<input type="hidden" name="hiddenParam" value="보이지않지만 전달되는값">
			<table>
			
				<tr>
					<th><label for="name">이름</label></th>
					<td><input type="text" name="name" id="name" class="name" 
					required="required" autofocus="autofocus"></td>
				</tr>
				
				<tr>
					<th><label for="id">아이디</label></th>
					<td><input type="text" name="id" id="id" class="id" 
					required="required"></td>
				</tr>
				
				<tr>
					<th><label for="pw">비밀번호</label></th>
					<td><input type="password" name="pw" id="pw" class="pw" 
					required="required"></td>
				</tr>
				
				<tr>
					<th><label for="pwChk">비밀번호확인</label></th>
					<td><input type="password" name="pwChk" id="pwChk" class="pwChk"></td>
				</tr>
				
				<tr>
					<th><label for="birth">생년월일</label></th>
					<td><input type="date" name="birth" id="birth" class="birth" 
					required="required"></td>
				</tr>
				
				<tr>
					<th>취미</th>
					<td>
					<input type="checkbox" name="hobby" value="독서" id="reading">
					<label for="reading">독서</label>
					<input type="checkbox" name="hobby" value="요리" id="cooking">
					<label for="cooking">요리</label>
					<input type="checkbox" name="hobby" value="운동" id="exersise">
					<label for="exersise">운동</label>
					<input type="checkbox" name="hobby" value="취침" id="sleep">
					<label for="sleep">취침</label>
					</td>
				</tr>
				
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="gender" value="m" id="m" checked="checked">
						<label for="m">남자</label>
						<input type="radio" name="gender" value="f" id="f">
						<label for="f">여자</label> 
					</td>
				</tr>
				
				<tr>
					<th><label for="email">이메일</label></th>
					<td>
					<input type="email" name="email" id="email" class="email" required="required" placeholder="hong@hong.com">
					</td>
				</tr>
				
				<tr>
					<th>메일수신</th>
					<td>
						<select name="mailSend" multiple="multiple" class="mailSend" >
							<option>광고</option>
							<option>배송</option>
							<option>공지</option>
							<option>댓글</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td colspan="2"></td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기" class="joinBtn_style">
						<input type="reset" value="다시하기" class="joinBtn_style">
						<input type="button" value="뒤로가기" class="joinBtn_style" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<footer>
		<div class="office_logo">
			<img src="https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png">
		</div>
		<div class="office_address">
			<ul>
				<li>서울시 XX구 XX로 000 XXX빌딩 8F | TEL : 02-999-9999 | FAX : 02-999-9998</li>
				<li>사업자등록번호 : 000-12-00000 | 통신판매업신로 : 종로 제0000호 | 대표이사 : 홍길동</li>
				<li>좋은시스템 문의 메일 : webmaster@joeun.com</li>
			</ul>
		</div>
		<div class="copyright">
			ⓒ2022 JOEUNSYSTEM.Co.,Ltd. All Rights Reserved.
		</div>
	</footer>
</body>
</html>