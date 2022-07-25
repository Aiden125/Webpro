package com.lec.ch19.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.Book;

public interface BookService {
	
	public List<Book> mainList();
	public List<Book> bookList(String pageNum); // 페이징이 되기에 pageNum 넣어서
	public int totCntBook();
	public Book getDetailBook(int bnum);
	
	// 파일 이름 받아야하니, mRequest선언
	public int registerBook(MultipartHttpServletRequest mRequest, Book book);
	public int registerBook(MultipartHttpServletRequest mRequest);
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book);
}
