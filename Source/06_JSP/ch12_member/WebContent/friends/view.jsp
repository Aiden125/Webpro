<%@page import="com.lec.friends.FriendsDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friends.FriendsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
	<script>
	function search(){
		var name = frm.phone.value;
		var phone = frm.phone.value;
		location.herf = 'view.jsp?name'+name;
	}
	</script>
</head>
<body>
<form action="insertAction.jsp" method="post" name="frm" id="frm">
	<table>
		<tr>
			<td colspan="5"> </td>
		</tr>
		<tr>
			<th>친구이름 </th>
			<td><input type="text" name="name"></td>
			<th>전화  </th>
			<td><input type="text" name="phone"></td>
			<td><input type="submit" value="추가"></td>
		</tr>
		<tr>
			<td colspan="5">
				이곳에 DB에 입력된 친구들 리스트
				<%
					FriendsDao Dao = new FriendsDao();
					ArrayList<FriendsDto> dtos = Dao.friendsAll();
					out.println("<p>순번 이름 번호</p>");
					if(dtos.size()!=0){
						for(FriendsDto dto : dtos)
							out.println("<p>"+dto.getNo() +dto.getName() +dto.getPhone()+"</p>");
					}else{
						out.println("친구가 없습니다");
					}
	
				%>
			</td>
		</tr>	
	</table>
</form>
</body>
</html>