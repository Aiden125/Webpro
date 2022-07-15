package com.lec.ch10.vo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class QuizValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Quiz.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 컨트롤러에서 호출 : validate(student, errors) 호출
		Quiz quiz = (Quiz)target;
		String name = quiz.getName();
		int kor = quiz.getKor();
		int eng = quiz.getEng();
		int math = quiz.getMath();
		if(name.length()<1) {
			// name 에러
			errors.rejectValue("name", "no"); // name 에러 등록
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "no");// name 에러 등록
		if(kor<0 || kor>100 || math<0 || math>100 || eng<0 || eng>100) {
			errors.rejectValue("kor", "no"); // score 에러 등록
		}
	}

	
}
