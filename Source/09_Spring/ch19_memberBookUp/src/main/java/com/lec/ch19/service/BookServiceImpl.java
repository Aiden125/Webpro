package com.lec.ch19.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dao.BookDao;
import com.lec.ch19.dto.Book;
import com.lec.ch19.util.Paging;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	String backupPath = "D:\\Webpro\\Source\\09_Spring\\ch19_memberBookUp\\src\\main\\webapp\\bookImgFileUpload/";
	
	// 그냥 리스트(페이징x)
	@Override
	public List<Book> mainList() {
		return bookDao.mainList();
	}

	// 페이징 리스트
	@Override
	public List<Book> bookList(String pageNum) {
		Paging paging = new Paging(bookDao.totCntBook(), pageNum, 3, 3);
		Book book = new Book();
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		return bookDao.bookList(book);
	}

	@Override
	public int totCntBook() {
		return bookDao.totCntBook();
	}

	@Override
	public Book getDetailBook(int bnum) {
		return bookDao.getDetailBook(bnum);
	}

	@Override
	public int registBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // temBimg1, tempBimg2
		String[] bimg = new String[2];
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx] != null && !bimg[idx].equals("")) { // 첨부함
				if(new File(uploadPath+bimg[idx]).exists()) {
					// 서버에 같은 파일이름이 있을 경우(첨부파일과)
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx]; 
				}// if
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업파일 : " + backupPath + bimg[idx]);
					boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx+"번째 백업 성공" : idx+"번째 백업 실패");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} 
			}else {
				// 파일 첨부 안하면 bimg[idx] = ""
				// bimg[idx] = "";
			}// if
			idx++;
		}// while
		book.setBimg1(bimg[0]); // 첫번째 첨부한 파일이름
		book.setBimg2(bimg[1]); // 두번째 첨부한 파일이름
		return bookDao.registBook(book); // DB insert
	}

	
	@Override
	public int registBook(MultipartHttpServletRequest mRequest) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // temBimg1, tempBimg2
		String[] bimg = new String[2];
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx] != null && !bimg[idx].equals("")) { // 첨부함
				if(new File(uploadPath+bimg[idx]).exists()) {
					// 서버에 같은 파일이름이 있을 경우(첨부파일과)
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx]; 
				}// if
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업파일 : " + backupPath + bimg[idx]);
					boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx+"번째 백업 성공" : idx+"번째 백업 실패");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} 
			}else {
				// 파일 첨부 안하면 bimg[idx] = ""
				// bimg[idx] = "";
			}// if
			idx++;
		}// while
		Book book = new Book();
		book.setBnum(Integer.parseInt(mRequest.getParameter("bnum")));
		book.setBtitle(mRequest.getParameter("btitle"));
		book.setBwriter(mRequest.getParameter("bwriter"));
		book.setBrdate(Date.valueOf(mRequest.getParameter("brdate")));
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		book.setBinfo(mRequest.getParameter("binfo"));
		return bookDao.registBook(book);
	}
	
	
	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // temBimg1, tempBimg2
		String[] bimg = new String[2];
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx] != null && !bimg[idx].equals("")) { // 첨부함
				if(new File(uploadPath+bimg[idx]).exists()) {
					// 서버에 같은 파일이름이 있을 경우(첨부파일과)
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx]; 
				}// if
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버파일 : " + uploadPath + bimg[idx]);
					System.out.println("백업파일 : " + backupPath + bimg[idx]);
					boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result ? idx+"번째 백업 성공" : idx+"번째 백업 실패");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} 
			}else {
				// 파일 첨부 안하면 bimg[idx] = ""
				// bimg[idx] = "";
			}// if
			idx++;
		}// while
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		return bookDao.modifyBook(book);
	}

	// file copy
		private boolean fileCopy(String serverFile, String backupFile) {
			boolean isCopy = false;
			FileInputStream is = null;
			OutputStream os = null;
			try {
				File file = new File(serverFile);
				is = new FileInputStream(serverFile);
				os = new FileOutputStream(backupFile);
				byte[] buff = new byte[(int)file.length()];
				while(true) {
					int nReadByte = is.read(buff);
					if(nReadByte == -1) break;
					os.write(buff, 0, nReadByte);
				}
				isCopy = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			return isCopy;
		}
		
}
