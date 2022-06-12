<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String conPath = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p{
	text-align:right;
	margin-right:10px;
}
h4{
	font-size:20px;
	text-align:center;
}
#wrap{
	width:310px;
	border:1px solid gray;
	text-align:center;
	margin:0 auto;
	padding-bottom:20px;
}
#table{
	height:200px;
	margin:0 auto;
}
tr{
	width:250px;
	height:100px;

	border:1px solid yellow;
	margin:10px 0;
	text-align:center;
	display:block;
	padding:5px;
}
page1{
	text-align:center;
	width:200px;
	display:block;
}
#submit{
	width:80px;
	height:40px;
}

</style>
</head>
<body>
<%
	session.setAttribute("E", 0);
	session.setAttribute("I", 0);
	session.setAttribute("S", 0);
	session.setAttribute("N", 0);
	session.setAttribute("F", 0);
	session.setAttribute("T", 0);
	session.setAttribute("P", 0);
	session.setAttribute("J", 0);
%>

<div id=wrap>
	<form action="./page2.jsp" method="post">
		<p>Q1</p>
		<h4>E인지 I인지?</h4>
		<table id=table>
			<tr>
				<td><label><input type="radio" name="page1" value="E"> E관련하여 올릴 공간입니다 여기다가 길게쓰면 어떻게되는지 까먹어서 다시 한번 해보는 ㅈ</label></td>
			</tr>
			<tr>
				<td><label><input type="radio" name="page1" value="I"> I관련하여 올릴 공간입니다</label></td>
			</tr>
		</table>
			<br><input type="submit" value="다음질문" id="submit">
	</form>
</div>
</body>
</html>