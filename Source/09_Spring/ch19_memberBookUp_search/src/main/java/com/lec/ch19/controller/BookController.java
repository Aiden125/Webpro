package com.lec.ch19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dto.Book;
import com.lec.ch19.service.BookService;
import com.lec.ch19.util.Paging;

@Controller
@RequestMapping(value="book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	// 책 리스트 화면
	@RequestMapping(params = "method=list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(String pageNum, Model model) {
		model.addAttribute("bookList", bookService.bookList(pageNum));
		model.addAttribute("paging", new Paging(bookService.totCntBook(), pageNum, 3, 3));
		return "book/list";
	}
	
	// 책 상세보기
	@RequestMapping(params = "method=detail", method = RequestMethod.GET)
	public String detail(int bnum, Model model) {
		model.addAttribute("bookDto", bookService.getDetailBook(bnum));
		return "book/detail";
	}
	
	// 책 등록 보기
	@RequestMapping(params = "method=registForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String registForm() {
		return "book/registForm";
	}
	
	// 책 등록
	@RequestMapping(params = "method=regist", method = RequestMethod.POST)
	public String registBook(MultipartHttpServletRequest mRequest, @ModelAttribute("bDto") Book book, Model model) {
		System.out.println("등록할께 : " + book);
		model.addAttribute("registResult", bookService.registBook(mRequest, book));
		return "book/registForm";
	}
	
	// 책 수정화면
	@RequestMapping(params = "method=modifyForm", method = RequestMethod.GET)
	public String modifyForm(int bnum, Model model) {
		model.addAttribute("bookDto", bookService.getDetailBook(bnum));
		return "book/modifyForm";
	}
	
	// 책 수정
	@RequestMapping(params = "method=modify", method = RequestMethod.POST)
	public String modify(MultipartHttpServletRequest mRequest, @ModelAttribute("bDto") Book book, Model model, String pageNum) {
		model.addAttribute("modifyResult", bookService.modifyBook(mRequest, book));
		System.out.println("수정완료");
		return "redirect:book.do?method=list&pageNum="+pageNum;
	}
}
