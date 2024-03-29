package com.lec.ch19.controller;

import java.io.Writer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.dto.Member;
import com.lec.ch19.service.MemberService;

@Controller
@RequestMapping(value="member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	// 회원가입 화면으로 가기
	@RequestMapping(params = "method=joinForm", method = RequestMethod.GET)
	public String joinForm() {
		return "member/joinForm"; 
	}
	
	// 아이디 중복확인
	@RequestMapping(params = "method=idConfirm", method = RequestMethod.GET)
	public String idConfirm(String mid, Model model) {
		model.addAttribute("result", memberService.idConfirm(mid));
		return "member/idConfirm";
	}
	
	// 회원가입 진행
	@RequestMapping(params = "method=join", method = RequestMethod.POST)
	public String join(@ModelAttribute ("mDto") Member member, HttpSession session, Model model) {
		model.addAttribute("joinResult", memberService.joinMember(member, session));
		return "member/loginForm";
	}
	
	// 로그인 화면으로 가기
	@RequestMapping(params = "method=loginForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		return "member/loginForm"; 
	}
	
	// 로그인하기
	@RequestMapping(params = "method=login", method = RequestMethod.POST)
	public String login(String mid, String mpw, HttpSession session ,Model model) {
		String result = memberService.login(mid, mpw, session);
		if(result.equals("로그인 성공")) {
			return "redirect:main.do";
		}else {
			model.addAttribute("mid", mid);
			model.addAttribute("mpw", mpw);
			model.addAttribute("result", result);
			return "forward:member.do?method=loginForm";
		}
	}
	
	// 정보수정 화면 가기
	@RequestMapping(params = "method=modifyForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm() {
		return "member/modifyForm";
	}
	
	// 정보수정
	@RequestMapping(params = "method=modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute("mDto") Member member, Model model, HttpSession session) {
		model.addAttribute("modifyResult", memberService.modifyMember(member));
		session.setAttribute("member", member);
		return "forward:main.do";
	}
	
	// 로그아웃
	@RequestMapping(params="method=logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:main.do";
	}
}
