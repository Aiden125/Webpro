package com.lec.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // 메시지 뿌리는 용도
public class HelloController {
	// @RequestMapping(value="/")
	@GetMapping("/") // Get방식으로 매핑할 때
	public String index() {
		return "index";
	}
	
	// @RequestMapping(value="/home", method = RequestMethod.GET)
	@GetMapping("/home")
	public String home(Model model) {
		log.info("첫 로그 메시지");
		model.addAttribute("greeting", "Hello, Spring Boot");
		return "home"; // resources/templates/home.html 경로로 이동
	}
}
