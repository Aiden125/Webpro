package com.lec.ch11.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch11.bservice.BContentService;
import com.lec.ch11.bservice.BListService;
import com.lec.ch11.bservice.BModifyReplyViewService;
import com.lec.ch11.bservice.BModifyService;
import com.lec.ch11.bservice.BWriteService;
import com.lec.ch11.bservice.Service;
import com.lec.ch11.dto.BoardDto;

// mvcboard/list.do, mvcboard/write.do, mvcboard/content.do 등으로
// 호출할거기 때문에 공통경로에 mvcboard 넣기
@Controller
@RequestMapping(value="mvcboard") // 공통 요청 경로
public class BoardController { 
	private Service bservice;
	
	// 리스트 조회하기(그냥 조회)
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(String pageNum, Model model) {
		// mvcboard/list.do?pageNum=2
		model.addAttribute("pageNum", pageNum);
		bservice = new BListService();
		bservice.execute(model);
		return "mvcboard/list";
	}
	
	// 리스트 조회하기(다른 곳에서 특정 메소드 실행 후 다시 요청할 때)
	@RequestMapping(value="/list", method = RequestMethod.POST)
	public String list_post(String pageNum, Model model) {
		// mvcboard/list.do?pageNum=2
		model.addAttribute("pageNum", pageNum);
		bservice = new BListService();
		bservice.execute(model);
		return "mvcboard/list";
	}
	
	// 글 작성 상세보기
	@RequestMapping(value="writeView", method = RequestMethod.GET)
	public String writeView() {
		return "mvcboard/write"; 
	}
	
	// 글 작성 실행
	@RequestMapping(value="write", method = RequestMethod.POST)
	public String write(@ModelAttribute("bDto") BoardDto boardDto,
			 			HttpServletRequest request,Model model) {
		model.addAttribute("request", request); // 서비스단에서 ip추출하기 위해서(request.getRemoteAddr())
		bservice = new BWriteService();
		bservice.execute(model);
		return "forward:list.do"; // 공통요청경로 빼고 요청
	}
	
	// 자세히보기 요청
	@RequestMapping(value="content", method = RequestMethod.GET)
	public String content(int bid, Model model) {
		model.addAttribute("bid", bid);
		bservice = new BContentService();
		bservice.execute(model);
		return "mvcboard/content";
	}
	
	// 자세히보기 요청(다른곳에서 오는 경우)
	@RequestMapping(value="content", method = RequestMethod.POST)
	public String content_post(int bid, Model model) {
		model.addAttribute("bid", bid);
		bservice = new BModifyReplyViewService();
		bservice.execute(model);
		return "mvcboard/content";
	}
	
	// 수정보기 요청
	@RequestMapping(value="modify", method = RequestMethod.GET)
	public String modifyView(int bid, Model model) {
		model.addAttribute("bid", bid);
		bservice = new BModifyReplyViewService();
		bservice.execute(model);
		return "mvcboard/modify";
	}
	
	// 수정 실행하기
	@RequestMapping(value="modify", method = RequestMethod.POST)
	public String modify(BoardDto boardDto, Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		bservice = new BModifyService();
		bservice.execute(model);
		return "forward:content.do"; // 수정 성공, 실패 알람을 띄어야 하기 때문에 forward로 넘김
	}
	
	// 삭제 실행하기
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String delete(int bid)
}
