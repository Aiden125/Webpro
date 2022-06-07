<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
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
		<caption>게시판</caption>
		<tr><td><a href="<%=conPath %>/board/writeForm.jsp">글쓰기</a></td></tr>
	</table>
	<table>
		<tr><th>글번호</th><th>작성자</th><th>글제목</th><th>메일</th><th>조회수</th></tr>
		<%
			/***********************************************************************/
			// list.jsp형태로 호출 또는 list.jsp?pageNum=11 또는 list.jsp?pageNum=1
			final int PAGESIZE = 10, BLOCKSIZE=10; //한 페이지에 보여줄 글 갯수, 한페이지에 출력된 블럭 수
			String pageNum = request.getParameter("pageNum");
			if(pageNum==null) {
				pageNum = "1"; //전달받은 페이지넘버가 없으면 1페이지로 세팅하겠다.
			}
			int currentPage = Integer.parseInt(pageNum); //파라미터가 스트링으로 넘어왔으니 형변환한걸 currentPage로
			int startRow = (currentPage-1) * PAGESIZE + 1;
			int endRow = startRow + PAGESIZE -1;
			/***********************************************************************/
			
			BoardDao dao = BoardDao.getInstance();
			int totalCnt = dao.getBoardTotalCnt(); // 등록된 total 글 갯수
			if(totalCnt==0){
				out.println("<tr><td colspan='5'>등록된 글이 없습니다</td>");
			}else{
				ArrayList<BoardDto> dtos = dao.listBoard(startRow, endRow); /***********/
				for(BoardDto dto : dtos){
					//글번호, 작성자
					out.println("<tr><td>"+dto.getNum()+"</td><td>"+dto.getWriter()+"</td>");
					//글제목<td class='left'><img src='/ch13_board/img/hot.gif'>
					//<a href='/ch13_board/board/content.jsp'>글제목</a></td>
					out.println("<td class='left'>");
					
					// 답변글 들여쓰기 - re.gif출력
					if(dto.getRe_indent() > 0){
						int width = dto.getRe_indent() * 20;
						// <img src='../img/re.gif' width=width, height='10'>
						out.println("<img src='../img/re.gif' width='"+width+"' hegiht='10'>");
					}
					
					
					// 조회수가 10 초과 시 img추가 출력
					if(dto.getReadcount() > 10){
						out.println("<img src='"+conPath+"/img/hot.gif'>");
					}
					// <a href='content.jsp?num=글번호&pageNum=현페이지수'>글 제목</a>
					out.println("<a href='"+conPath + "/board/content.jsp?num="+dto.getNum()+
																"&pageNum=" + pageNum + "'>"
																	+ dto.getSubject()+"</a></td>");
					//메일, 조회수
					out.println("<td>"+(dto.getEmail()!=null ? dto.getEmail() : "")+"</td><td>"+dto.getReadcount()+"</td></td>");
				}
			}
		%>
	</table>
	<div class="paging">
	<%
		int pageCnt = (int)Math.ceil((double)totalCnt / PAGESIZE); // 페이지 갯수(대략 전체/10)(다음 블록여부 판단을 위해)
		int startPage = ((currentPage-1)/BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1; //끝나는 페이지가 총 페이지보다 크면 조정해줘야함
		if(endPage > pageCnt){ // 끝나는페이지가 총 페이지보다 크냐?
			endPage = pageCnt;
		}
		if(startPage > BLOCKSIZE){ // 이전 페이지가 있냐? 만약 있다면 이런식으로 넣기<a href="list.jsp?pageNum=10">이전</a>
			out.println("[ <a href='list.jsp?pageNum="+(startPage-1)+"'>이전</a> ]");
		}
		for(int i=startPage ; i<=endPage ; i++){ // 하단부에 페이지 번호 뿌리기
			if(i==currentPage){ //현재 페이지에 해당하는 번호는 페이지 수만 출력(링크없이)(빨간색으로)
				out.println(" [ <b>" + i + "</b> ] ");
			}else{ //다른 페이지들은 누르면 갈 수 있게 링크걸기<a href='list.jsp?pageNum=10'>10</a>
				out.println(" [ <a href='list.jsp?pageNum="+i+"'>"+i+"</a> ] ");
			}
		}
		if(endPage < pageCnt){ //다음 블록이 있냐? 있다면 <a href='list.jsp?pageNum=다음블록 첫페이지'>다음</a>
			out.println("[ <a href='list.jsp?pageNum="+ (endPage+1) + "'>다음</a> ] ");
		}
	%>
	</div>	
</body>
</html>








