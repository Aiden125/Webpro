<!-- 특정 세션 속성값(value) 가져오기.
key, value 값 가져오기라고 생각하면 편함
setAttribute, getAttribute 함수 이용이 가능한데
get할때는 object타입으로 리턴해주기 때문에 변수에 할당 할 때 형변환 필수 -->

<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%  //특정 세션 속성값 가져오기
	//getAttribute는 리턴타입이 object타입이기 때문에 알맞는 타입으로 형변환
	String sessionName = (String)session.getAttribute("sessionName");
	Integer myNum = (Integer)session.getAttribute("myNum");
	
	out.println("sessionName : " + sessionName + "<br>");
	out.println("myNum : " + myNum + "<br>");
	out.println("id : " + session.getAttribute("id") + "<br>"); //추가한 속성이 없을 경우 null
	
	//모든 세션 속성리스트 출력
	out.println("<h4>모든 세션 list</h4>");
	Enumeration<String> sAttrNames = session.getAttributeNames();
	int cnt=0;
	while(sAttrNames.hasMoreElements()){
		String sname = sAttrNames.nextElement();
		String svalue = session.getAttribute(sname).toString(); //세션(속성)값
		out.println(sname+"(세션이름key) / " + svalue + "(세션값value)<br>");
		cnt++;
	}
	if(cnt==0){
		out.println("추가된 세션이 없습니다.");
	}
	
	
	
	// 특정 세션 삭제하기(로그아웃 시 사용)
	session.removeAttribute("myNum"); //myNum 세션 속성 삭제
	
	out.println("<h4>myNum 세션 삭제 후</h4>");
	sAttrNames = session.getAttributeNames();
	cnt=0;
	while(sAttrNames.hasMoreElements()){
		String sname = sAttrNames.nextElement();
		String svalue = session.getAttribute(sname).toString(); //세션(속성)값
		out.println(sname+"(세션이름key) / " + svalue + "(세션값value)<br>");
		cnt++;
	}
	if(cnt==0){
		out.println("추가된 세션 속성(value)이 없습니다.");
	}
	
	
	// 모든 세션 삭제하기(로그아웃 시 사용)
	out.println("<h4>모든 세션 삭제 후</h4>");
	session.invalidate(); //setAttribute했던 모든 세션 속성값 다 삭제
	if(request.isRequestedSessionIdValid()){ //유효한 세션 속성이 있는지 여부
		out.println("유효한 session이 있습니다(valid)<br>");
	}else {
		out.println("유효한 session이 없습니다(invalid)<br>");
	}
	out.println("<h4>세션ID : " + session.getId() + "</h4>");
	out.println("<h4>세션의 유효시간 : " + session.getMaxInactiveInterval() + "<br>");
%>	
</body>
</html>