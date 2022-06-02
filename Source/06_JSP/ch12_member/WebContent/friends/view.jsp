<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friends.FriendsDao"%>
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
</head>
<body>
	<table>
		<tr>
			<td colspan="5"> </td>
		</tr>
		<tr>
			<th>친구이름 </th>
			<td><input type="text" name="fName"></td>
			<th>전화  </th>
			<td><input type="text" name="fPhone"></td>
			<td><button onclick="location.href='insertAction.jsp'">추가</button></td>
		</tr>
		<tr>
			<td colspan="5">
				이곳에 DB에 입력된 친구들 리스트
				<%
					FriendsDao Dao = FriendsDao.getInstance();
					ArrayList<FriendsDto> dtos = Dao.friendsAll();
					if(dtos.size()!=0){
						for(FriendsDto dto : dtos)
						out.println("<td>"+dto.getNo()+dto.getName()+dto.getPhone()+"</td>");
					}else{
						out.println("<td>친구가 없습니다</td>");
					}
	
				%>
			</td>
		</tr>	
	</table>
</body>
</html>