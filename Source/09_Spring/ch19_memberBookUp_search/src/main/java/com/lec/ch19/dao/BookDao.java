package com.lec.ch19.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.Book;

@Mapper
public interface BookDao {
	public List<Book> mainList();
	public List<Book> bookList(Book book);
	public int totCntBook();
	public Book getDetailBook(int bnum);
	public int registBook(Book book);
	public int modifyBook(Book book);
}