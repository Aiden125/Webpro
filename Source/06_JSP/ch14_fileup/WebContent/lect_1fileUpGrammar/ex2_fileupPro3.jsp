<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>

					<!-- 파일 3개(1,2,3)을 받아왔을 때 3,2,1 순서대로 읽어온다 -->

<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
<%
	String path = request.getRealPath("fileUpFolder"); // 실제 파일 저장할 위치
	int maxSize = 1024*1024*10; // 최대용량 10MB로 제한
	String[] filename = {"","",""};
	String[] originFilename = {"","",""};
	try{
		MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8",
				new DefaultFileRenamePolicy());
		// new DefaultFileRenamePolicy() : 서버에 같은 이름의 파일이 있을 경우 rename을 자동으로. ex) 풍경.jpg -> 풍경1.jpg
		Enumeration<String> paramNames = mRequest.getFileNames(); // 파라미터 네임
		int idx = 0;
		while(paramNames.hasMoreElements()){ // 파라미터가 다음 값이 있으면 반복해
			String param = paramNames.nextElement(); // 파라미터 이름
			filename[idx] = mRequest.getFilesystemName(param); // 해당 파라미터 이름으로 저장된 파일 이름
			originFilename[idx] = mRequest.getOriginalFileName(param);
			System.out.println(idx+"번 째 파라미터 : " +param + ", 저장파일 : " + filename[idx] +
									", 원 파일명 : " +originFilename[idx]);
			idx++;
		}// while
	}catch(IOException e){
		System.out.println(e.getMessage());
	}// try
	
	
	// 서버에 저장된 파일을 소스폴더로 복사해오자.
	for(String f : filename)
		if(f!=null){
			InputStream is = null;
			OutputStream os = null;
			try{
				File serverfile = new File(path+"/"+f); // 내가 파일 첨부를 했다면 존재할거고 안했으면 null
				if(serverfile.exists()){ // 첨부한 파일이 존재해?
					is = new FileInputStream(serverfile); // 원본 파일에 빨대꼽기
					os = new FileOutputStream("D:/Webpro/Source/06_JSP/ch14_fileup/WebContent/fileUpFolder/"+f); // 복사할 파일
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
	}
%>


	<%=Arrays.toString(filename) %>
	<%=Arrays.toString(originFilename) %>
	<h2>파일1 첨부 파일</h2>
	<h5><%=path %>/<%=filename[2] %></h5> <!-- 거꾸로 쌓이기에 2번 인덱스로 해야 첫번째 파일 불러옴 -->
	<img src="../fileUpFolder/<%=filename[2] %>" alt="첫번째 첨부파일">
	
	<h2>파일2 첨부 파일</h2>
	<h5><%=path %>/<%=filename[1] %></h5>
	<img src="../fileUpFolder/<%=filename[1] %>" alt="두번째 첨부파일">
	
	<h2>파일3 첨부 파일</h2>
	<h5><%=path %>/<%=filename[0] %></h5>
	<img src="../fileUpFolder/<%=filename[0] %>" alt="세번째 첨부파일">
	
</body>
</html>