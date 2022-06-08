<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
							<!-- 파일 첨부 여러개 하기 -->
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
				<!-- 파일첨부할때는 반드시 post로, enctype 값 꼭 써야함 -->
	<form action="ex2_fileupPro3.jsp" method="post" enctype="multipart/form-data"> 
		<p>파일1<input type="file" name="file1">
		<p>파일2<input type="file" name="file2">
		<p>파일3<input type="file" name="file3">
		<input type="submit" value="파일업로드" class="btn">
	</form>	
</body>
</html>