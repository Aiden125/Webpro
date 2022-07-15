package com.lec.ch08.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 슬래시만 입력해도 어디 가라할거기 때문에 공통경로는 안적음
public class MyController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 5;
	}
	@ModelAttribute("list")
	public ArrayList<String> list(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		return list;
	}
	@RequestMapping(value="/")
	public String input(Model model) {
		// model.addAttribute("cnt", 5);
		return "member/input";
	}
	
//	// 아이디 넘어온 파라미터 잡기
//	@RequestMapping(value="studentId/*")
//	public String studentId(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
//		String uri = request.getRequestURI(); // "ch08/studentId/aaa"
//		String id = uri.substring(uri.lastIndexOf("/")+1);
//		// 스프링은 한글을 자동 인코딩해서 넘겨줄 때는 반드시 다시 바꿔주어야함
//		id = URLDecoder.decode(id, "utf-8");
//		model.addAttribute("id", id);
//		return "studentId";
//	}
	
	// 위에 방법을 더 간단하게 하기
	@RequestMapping(value="studentId/{id}")
	public String studentId(@PathVariable("id") String id, Model model) {
		model.addAttribute("id", id);
		return "studentId";
	}
}
