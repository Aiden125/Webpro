<%@page import="java.sql.Date"%>
<%@page import="java.io.File"%>
<%@page import="com.lec.book.BookDto"%>
<%@page import="com.lec.book.BookDao"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
						<!-- 파일 등록을 위한 페이지 -->
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
<% // 필요 과정 : 한글 인코딩처리 - multipartRequest객체 생성 - 첨부된 파일 명 get - 그 외 파라미터 정보 받기 - dao에 인서트
	request.setCharacterEncoding("utf-8");
	String path = request.getRealPath("bookimg");
	int maxSize = 1024*1024*5; // 최대 업로드 용량 5MB
	String[] image = {"",""}; // 저장된 파일명 저장소
	MultipartRequest mRequest = null;
	try{
		// multipartRequest 객체 생성
		mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		// 첨부된 파일이 저장된 파일명 get
		Enumeration<String> paramNames = mRequest.getFileNames(); // 파라미터 이름들(image2, image1)
		int idx = 0;
		while(paramNames.hasMoreElements()){
			String param = paramNames.nextElement();
			image[idx] = mRequest.getFilesystemName(param); // 저장된 파일명
			idx++;
		}// while
		
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	// 서버의 bookimg폴더 파일을  소스의 bookimg폴더로 복사
	for(String img : image){
		if(img!=null){
			InputStream is = null;
			OutputStream os =null;
			File serverFile = new File(path+"/"+img);
			try{
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/Webpro/Source/06_JSP/ch14_fileup/WebContent/bookimg/"+img);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true){
					int readbyteCnt = is.read(bs);
					if(readbyteCnt==1) break;
					os.write(bs,  0, readbyteCnt);
				}
			} catch(Exception e){
				System.out.println(e.getMessage());
			} finally{
				if(os!=null) os.close();
				if(is!=null) is.close();
			}
		} 
	}
	
	// 파일 첨부 외 파라미터에서 입력된 정보 get
	int bid = 0;
	String btitle = mRequest.getParameter("btitle");
	int bprice = Integer.parseInt(mRequest.getParameter("bprice"));
	String bimage1 = image[1]==null? "noimg.png" : image[1];
	String bimage2 = image[0]!=null? image[0]:"NOTHING.JPG";
	String bcontent = mRequest.getParameter("bcontent");
	int bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));
	Date brdate = null;
	
	// DB에 insert
	BookDao bDao = BookDao.getInstance();
	BookDto book = new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate);
	int result = bDao.insertBook(book);
	if(result == BookDao.SUCCESS){
		out.println("<h2>책 등록 성공</h2>");
	}else{
		out.println("<h2>책 등록 실패</h2>");
	}
%>	
	<h3>책이름 : <%=btitle %></h3>
	<h3>책대표이미지 : <%=path %>/<%=bimage1 %></h3>
	<img src="<%=conPath %>/bookimg" alt="대표이미지">
	<h3>책이미지2 : <%=path + "/" + bimage2 %></h3>
	<img src="../bookimg/<%=bimage2 %>">
	<h3>책 설명</h3>
	<pre><%=bcontent %></pre>
	<h3>책 가격 : <del><%=bprice %></del> <%=bprice*(100-bdiscount)/100 %>원</h3>
	<h3>할인률 : <%=bdiscount %></h3>
	<a href="ex3_list_board.jsp">책 전체 리스트(게시판 스타일)</a>
	<a href="ex3_list_boardp.jsp">책 리스트(paging게시판 스타일)</a>
	<a href="ex3_list_product.jsp">책 전체 리스트(쇼핑몰 스타일)</a>
	<a href="ex3_list_productp.jsp">책 리스트(paging쇼핑몰 스타일)</a>
</body>
</html>