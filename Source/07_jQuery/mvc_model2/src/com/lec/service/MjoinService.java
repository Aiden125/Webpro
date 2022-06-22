package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MjoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024; // 사진 업로드 제한 용량 : 1MB
		String mphoto = ""; // 첨부된 파일이 저장된 파일 이름
		try {
			// mRequest 객체 생성 후 mPhoto 파일이름 얻어옴
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize,
							"utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			// while(params.hasMoreElements()) {
				String param = params.nextElement();
				mphoto = mRequest.getFilesystemName(param);
			// }
				
			// mRequest 이용해 파라미터 가져와 DB 저장
			String mid = mRequest.getParameter("mid");
			String mpw = mRequest.getParameter("mpw");
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			mphoto = (mphoto == null? "NOIMG.JPG" : mphoto);
			String mbirthStr = mRequest.getParameter("mbirth");
			Date mbirth = null;
			if(!mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
			String maddress = mRequest.getParameter("maddress");
			MemberDao mDao = MemberDao.getInstance();
			
			MemberDto member = new MemberDto(mid, mpw, mname, memail,
										mphoto, mbirth, maddress, null);
			mDao.joinMember(member);
			HttpSession session = request.getSession(); // 세션은 request로 부터
			session.setAttribute("mid", mid);
			request.setAttribute("joinResult", "회원가입이 완료되었습니다");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// 서버에 업로드 된 파일을 소스 폴더로 복사
		File serverFile = new File(path +"/" + mphoto);
		if(serverFile.exists() && !mphoto.equals("NOIMG.JPG")) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\Webpro\\Source\\06_JSP\\ch19_mvcmember\\WebContent\\memberPhotoUp\\"+mphoto);
				byte[] bs = new byte[(int) serverFile.length()];
				while(true) {
					int readByteCnt = is.read(bs);
					if(readByteCnt==-1) {
						break;
					}
					os.write(bs, 0, readByteCnt);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
