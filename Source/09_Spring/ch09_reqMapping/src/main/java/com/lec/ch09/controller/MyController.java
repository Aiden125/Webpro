package com.lec.ch09.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping(value="main.do", method = RequestMethod.GET)
	public String main() {
		return "main";
	}
	
//	@RequestMapping(value="student")
//	public String student(String id, Model model, HttpServletRequest request) {
//		String method = request.getMethod();
//		model.addAttribute("method", method);
//		model.addAttribute("id", id);
//		return "studentId";
//	}
	
	@RequestMapping(value="student", method = RequestMethod.GET)
	public String student(String id, Model model) {
//		String method = request.getMethod();
		model.addAttribute("method", "GET");
		model.addAttribute("id", id);
		return "studentId";
	}

	@RequestMapping(value="student", method = RequestMethod.POST)
	public ModelAndView student(String id, ModelAndView mav) {
//		String method = request.getMethod();
		mav.addObject("method", "POST");
		mav.addObject("id", id);
		mav.setViewName("studentId");
		return mav;
	}

	@RequestMapping(value="idConfirm", method = RequestMethod.GET)
	public String idConfirm(String id, Model model) {
		model.addAttribute("id", id);
		if(id.equals("aaa")) {
			return "forward:student.do";
		}
		return "redirect:studentNg.do?id="+id; // 싹 다 날라가니까 다시 넣기
	}
	
	@RequestMapping(value="studentOk", method = RequestMethod.GET)
	public String studentOk() {
		return "studentOk";
	}
	
	@RequestMapping(value="studentNg", method=RequestMethod.GET)
	public String studentNg(String id) {
		return "studentNg";
	}
	
	@RequestMapping(value="fullPath", method = RequestMethod.GET)
	public String fullpath() {
		return "redirect:http://www.naver.com";
	}
	
}
