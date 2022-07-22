package com.lec.ch17.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch17.util.Paging;
import com.lec.ch17.bservice.BoardService;
import com.lec.ch17.dto.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// 글 목록 보여주기
//	@RequestMapping(value="boardList", method = RequestMethod.GET)
//	public String boardList(Model model) {
//		model.addAttribute("boardList", boardService.boardList());
//		return "list";
//	}
	
	// 페이징된 글 목록 보여주기
	@RequestMapping(value="boardList", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardList(String pageNum, Model model) {
		model.addAttribute("boardList", boardService.boardList(pageNum));
		model.addAttribute("paging", new Paging(boardService.totCnt(), pageNum, 10, 5));
		return "list";
	}
	
	// 글 작성view
	@RequestMapping(value="writeView", method = RequestMethod.GET)
	public String writeView() {
		return "write";
	}
	
	// 글 작성하기
	@RequestMapping(value="write", method = RequestMethod.POST)
	public String write(Board board, HttpServletRequest request, Model model) {
		model.addAttribute("writeResult", boardService.write(board, request));
		return "forward:boardList.do";
	}
	
}
