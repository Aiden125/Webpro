package com.lec.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.vo.Student;
import com.lec.ch10.vo.StudentValidator;

@Controller
public class MyController {
	
	@RequestMapping(value="inputForm.do", method = RequestMethod.GET)
	public String inputForm() {
		return "ex/inputForm";
	}
	
	@RequestMapping(value="input.do", method = RequestMethod.GET)
	public String input(Student student, Errors errors, Model model) {
		String viewPage = "ex/inputResult";
		// 검증객체를 이용해서 검증 method 호출
		StudentValidator validator = new StudentValidator();
		validator.validate(student, errors);
		
		if(errors.hasErrors()) { //에러가 있냐?
			if(errors.getFieldError("name") != null) {
				model.addAttribute("nameError", "name은 필수입력사항");
			}
			if(errors.getFieldError("id") != null) {
				model.addAttribute("idError", "id는 자연수입니다");
			}
			return "ex/inputForm";
		}
		// if(에러를 잡았다){
		// viewPage = "ex/inputForm"
		// 에러난 곳에 점검 메시지 model에 add }
		return "ex/inputResult";
	}
}
