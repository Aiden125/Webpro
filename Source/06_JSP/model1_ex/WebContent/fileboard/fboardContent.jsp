<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="com.lec.dao.FileboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
	<style>
		#content_form{
			height: 570px; 
			padding-top:30px;
		}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
	<%
		String pageNum = request.getParameter("pageNum");
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		FileboardDao fbDao = FileboardDao.getInstance();
		fbDao.hitUp(fnum);
		FileboardDto fbDto = fbDao.getBoard(fnum);
	%>
	<table>
		<caption>글 상세보기</caption>
		<tr><th>글번호</th><td><%=fbDto.getFnum() %></td></tr> 
		<tr><th>글제목</th><td><%=fbDto.getFsubject() %></td></tr>
		<tr>
			<th>작성자</th>
			<td>
				<%=fbDto.getCname() %> : <%=fbDto.getCid() %>
				(<a href="mailto:<%=fbDto.getCemail()!=null? fbDto.getCemail() : ""%>">
				<%=fbDto.getCemail()!=null? fbDto.getCemail() : "-" %></a>)
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td>
			<%
				if(fbDto.getFfilename()==null){
					out.println("첨부파일 없음");
				}else{
					out.println("<a href='../fileboardUpload/"+fbDto.getFfilename() + "'>"
							+fbDto.getFfilename() + "</a>");
				}
			%>
			</td>
		</tr>
		<tr>
			<th>본문</th><td><pre><%=fbDto.getFcontent() %></pre></td>
		</tr>
		<tr>
			<th>작성일</th><td><pre><%=fbDto.getFrdate() %></pre></td>
		</tr>
		<tr>
			<th>조회수</th><td><pre><%=fbDto.getFhit() %></pre></td>
		</tr>
		<tr>
			<th>IP</th><td><pre><%=fbDto.getFip() %></pre></td>
		</tr>
		<tr>
			<td colspan="2"> <!-- 목록/수정/삭제/답변 -->
				<button onclick="location.href='fboardList.jsp?pageNum=<%=pageNum%>'">목록</button>
				<%
					String cid = null;
					CustomerDto customer = (CustomerDto)session.getAttribute("customer");
					if(customer!=null){
						cid = customer.getCid();
					}
					if(fbDto.getCid().equals(cid)){%>
						<button onclick="location.href='fboardUpdateForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">수정</button>	
				<% 	}%>
				<%if(customer!=null){ %>
					<button onclick="location.href='fboardWriteForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">답변</button>
				<%} %> 
				<button onclick="location.href='fboardDeleteForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">삭제</button>
			</td>
		</tr>
	</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>