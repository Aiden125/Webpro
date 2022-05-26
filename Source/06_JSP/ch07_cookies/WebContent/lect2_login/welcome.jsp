<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
	String id=null, name=null;
	Cookie[] cs = request.getCookies();
	if(cs!=null){ //쿠키가 널이 아니라면
		for(int i=0; i<cs.length; i++){
			if(cs[i].getName().equals("id")){ //쿠키가 id 쿠키냐?
				id = cs[i].getValue(); //로그인 했으면 id값이 밸류로		
			}else if(cs[i].getName().equals("name")){
				name = cs[i].getValue();
			}
		} //로그인 전 : id변수와 name변수에 null값
		  //로그인 후 : id 변수에 로그인한 id가. name변수엔 로그인한 name을 할당
	}//if
%>

<%
if(name!=null){ //로그인 후 화면
%>
<h1><%=name %>(<%=id %>)님 반갑습니다</h1>
<button onclick="location.href='logout.jsp'">로그아웃</button>
<button onclick="location.href='cookieList.jsp'">쿠키들 확인</button>
<%
}else { //로그인 전 화면
%>
	<h1>손님(guest)반갑습니다. 로그인하세요</h1>
	<button onclick="location.href='login.html'">로그인</button>
	<button onclick="location.href='cookieList.jsp'">쿠키들 확인</button>
<%
}
%>

</body>
</html>