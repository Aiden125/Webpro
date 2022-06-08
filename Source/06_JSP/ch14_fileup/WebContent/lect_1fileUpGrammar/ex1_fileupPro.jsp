<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
<%
	String path = request.getRealPath("fileUpFolder"); // 실제로 파일을 저장할 위치(여기에만 저장된다)
	//out.println(path);
	int maxSize = 1024*1024*10; // 업로드 최대용량을 10MB로 설정함
	String filename = ""; // 서버에 저장될 파일 이름
	String originalFileName = ""; // 업로드한 오리지널 파일 네임
	
	try{
		MultipartRequest multipartRequest = new MultipartRequest(request, path, maxSize, "utf-8",
									new DefaultFileRenamePolicy());
		// new DefaultFileRenamePolicy() : 서버에 같은 이름의 파일이 있을 경우 rename을 자동으로. ex) 풍경.jpg -> 풍경1.jpg
		Enumeration<String> paramNames = multipartRequest.getFileNames(); //파라미터 이름들
		String param = paramNames.nextElement(); // 파라미터 이름 file을 넣어준다
		filename = multipartRequest.getFilesystemName(param); //파라미터 이름으로 저장된 파일 이름
		originalFileName = multipartRequest.getOriginalFileName(param); //오리지널 파일 이름
		// 파일 첨부를 하지 않을 경우 filename과 originalFileName에서는 null
		System.out.println("파라미터 이름 : " + param + "/서버에 저장된 파일이름 : " + filename +
											"/ 사용자가 업로드한 오리지널 파일 이름 : "+originalFileName);
	}catch(IOException e){
		System.out.println(e.getMessage());
	}
	
	// 서버 fileUpFolder에 있는 파일은 매우 불안하다. 때문에 temp 폴더를 만들자.
	// 서버 fileUpFolder 폴더에 업로드한 파일을 소스의 fileUpFolder폴더로 file copy
	InputStream is = null;
	OutputStream os = null;
	try{
		File serverfile = new File(path+"/"+filename); // 내가 파일 첨부를 했다면 존재할거고 안했으면 null
		if(serverfile.exists()){ // 첨부한 파일이 존재해?
			is = new FileInputStream(serverfile); // 원본 파일에 빨대꼽기
			os = new FileOutputStream("D:/Webpro/Source/06_JSP/ch14_fileup/WebContent/fileUpFolder/"+filename); // 복사할 파일
			byte[] bs = new byte[(int)serverfile.length()]; // 서버파일의 크기만큼 담겠다(옮기기 위한 도구)
			while(true){
				int nReadCnt = is.read(bs); // 파일의 끝이 읽어들인 byte수가 : nReadCnt
				if(nReadCnt == -1) break; //-1이면 파일의 끝이기에 스탑해
				os.write(bs, 0, nReadCnt); //다 읽었으면 적어(0번 인덱스부터 nReadCnt까지)
			}//while
			System.out.println("서버 첨부& 복사 완료"); // 그냥 확인용
		}//if
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		 if(os!=null) os.close();
		 if(is!=null) is.close();
	}
	
	
	/**************** 오리지널 파일이름, 서버저장루트를 보기위한 부분 *********************/
	if(filename!=null){ //파일을 첨부했어? 첨부했으면 실행해
%>
		<h3>첨부한 오리지널 파일 이름 : <%=originalFileName %></h3>
		<h3>서버에 저장된 파일 : <%=path %>/<%=filename %></h3>
		<img src="<%=conPath %>/fileUpFolder/<%=filename %>" alt="첨부파일">
<% 		
	}else{ //첨부 안했으면 실행해
		out.println("<h2>첨부 안함</h2>");
	}
%>	
</body>
</html>