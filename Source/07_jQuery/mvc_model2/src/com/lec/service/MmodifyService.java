package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

public class MmodifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024;
		String mphoto = "";
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize,
									"utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			mphoto = mRequest.getFilesystemName(param);
			
			String mid = mRequest.getParameter("mid");
			String mpw = mRequest.getParameter("mpw");
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			
			String dbmphoto = mRequest.getParameter("dbmphoto");
			mphoto = (mphoto==null)? dbmphoto : mphoto;
			String mbirthStr = mRequest.getParameter("mbirth");
			Date mbirth = null;
			if(mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
			String maddress = mRequest.getParameter("maddress");
			
			MemberDao mDao = MemberDao.getInstance();
			
			MemberDto member = new MemberDto(mid, mpw, mname, memail, dbmphoto, mbirth, maddress, null);
			int result = mDao.memberModify(member);
			if(result == MemberDao.SUCCESS) {
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				request.setAttribute("modifyResult", "회원정보 수정 성공");
			}else {
				request.setAttribute("modifyResult", "회원정보 수정 실패");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// 업로드된 파일 복사하기
		File serverFile = new File(path+"/"+mphoto);
		if(!mphoto.equals("NOIMG.JPG") && serverFile.exists()) {
			InputStream is = null;
			OutputStream os = null;
			
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\Webpro\\Source\\07_jQuery\\mvc_model2\\WebContent\\memberPhotoUp"+mphoto);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true) {
					int readbyteCnt = is.read(bs);
					if(readbyteCnt == -1) {
						break;
					}
					os.write(bs, 0, readbyteCnt);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
