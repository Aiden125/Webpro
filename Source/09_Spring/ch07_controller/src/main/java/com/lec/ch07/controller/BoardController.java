package com.lec.ch07.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch07.dto.Member;

@Controller
// board/write, board/content, board/list, board/reply
@RequestMapping("board") // 공통요청경로(클래스 위에 놓으면 공통요청경로)
public class BoardController {
	
	@RequestMapping(value="write") // value는 디폴트기에 써도 안써도 상관 x
	public String write() {
		return "board/write"; // 뷰 : /WEB-INF/views/board/write.jsp
	}
	
	@RequestMapping(value="content", method=RequestMethod.GET)
	public String content(Model model/* , HttpServletRequest request */) {
//		request.setAttribute("id", "aaa"); 이건 jsp 방식(되긴 되나 안씀)
		model.addAttribute("id", "aaa");
		model.addAttribute("pw", "1234");
		Member member = new Member("bbb", "222");
		model.addAttribute("member", member);
		return "board/content";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		Member member = new Member("ccc", "111");
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(member);
		mav.addObject("list", list);
		mav.setViewName("board/list"); // view
		return mav;
	}
	
	@RequestMapping(value="reply", method=RequestMethod.GET)
	public ModelAndView reply(ModelAndView mav) {
		Member member = new Member("ddd", "1234");
		mav.addObject("member", member);
		mav.setViewName("board/reply");
		return mav;
	}
}
