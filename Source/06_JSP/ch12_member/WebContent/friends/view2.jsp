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
		var name = frm.name.value;
		var phone = frm.phone.value;
		location.href = 'view2.jsp?name='+name+"&phone="+phone;
	}
	</script>
</head>
<body>
<form action="insertAction2.jsp" name="frm">
	<table>
		<tr>
			<td colspan="6"> </td>
		</tr>
		<tr>
			<th>친구이름 </th>
			<td><input type="text" name="name" id="name" value="<%
											String name = request.getParameter("name");
											if(name!=null) out.println(name);
			%>"></td>
			<th>전화  </th>
			<td><input type="text" name="phone" id="phone" value="<%
											String phone = request.getParameter("phone");
											if(phone!=null) out.println(phone);
			%>"></td>
			<td><input type="button" onclick="search()" value="검색"></td>
			<td><input type="submit" value="추가"></td>
		</tr>
		<tr>
			<td colspan="6">
				<p>이곳에 DB에 입력된 친구들 리스트</p>
				<p>순번 이름 번호</p>
				<%
					FriendsDao Dao = new FriendsDao();
					ArrayList<FriendsDto> dtos = Dao.searchFriends(name, phone);
					for(FriendsDto friend : dtos){
						System.out.println(friend);
						out.println("<p>"+friend.getNo() +":"+ (friend.getName()==null? "":friend.getName()) + (friend.getPhone()==null? "":friend.getPhone())+"</p>");
					}
	
				%>
			</td>
		</tr>	
	</table>
</form>
</body>
</html>