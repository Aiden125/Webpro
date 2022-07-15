package com.lec.ch08.controller;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.ch08.vo.MemberDto;

@Controller
@RequestMapping("member")
public class MemberController {
	
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
	
	@RequestMapping(value="join1")
	public String join1(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/result1";
	}
	
	// name이라는 파라미터가 있으면 받아서 membername 변수에 넣어라
	// 생년월일 같은거 넣을 때 받아서 바꾸는 등 간혹 써야함
	@RequestMapping(value="join2")
	public String join2(@RequestParam("name") String membername ,
			@RequestParam("id") String memberid,
			@RequestParam("pw") String memberpw,
			@RequestParam("age") String memberage, // 알아서 integer int로 변환해줌
			@RequestParam("email") String memberemail,
			@RequestParam("address") String memberaddress, Model model) {
		model.addAttribute("name", membername);
		model.addAttribute("id", memberid);
		model.addAttribute("pw", memberpw);
		model.addAttribute("age", memberage);
		model.addAttribute("email", memberemail);
		model.addAttribute("address", memberaddress);
		return "member/result1";
	}
	
	@RequestMapping(value="join3")
	public String join3(String name, String id, String pw, int age, String address, String email, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("address", address);
		model.addAttribute("email", email);
		model.addAttribute("name", name);
		return "member/result1";
	}
	
	
	// Dto에 다 설정해서 하는 방법도 존재하나 그렇게는 잘 안쓴다
	
	
	// 파라미터가 날라오면 알아서 Dto 속성으로 들어감
	// 반드시 Dto의 데이터 이름을 같게 해줘야함
	@RequestMapping(value="join4")
	public String join4(MemberDto memberDto, Model model) {
		model.addAttribute("member", memberDto);
		return "member/result4";
	}
	
	
	// 조인4에서 더 줄이고 싶다면?
	// 모델을 안써도 같은 방법을 한다.
	// 하지만 반드시 매개변수 없는 생성자가 있어야한다.
	@RequestMapping(value="join5")
	public String join5(MemberDto memberDto/* , Model model */) {
		// 이거 안써줘도 함
		// model.addAttribute("member", memberDto);
		return "member/result5";
	}
	
	
	// memberDto에다가 속성추가 하는게 아닌 member에다가 속성추가하고 싶다
	@RequestMapping(value="join6")
	public String join6(@ModelAttribute("member") MemberDto memberDto) {
		return "member/result4";
	}
	
}













