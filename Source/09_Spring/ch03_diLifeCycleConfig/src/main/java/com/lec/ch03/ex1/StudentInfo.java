package com.lec.ch03.ex1;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

// Student를 의존하는 SudentInfo
@Data
public class StudentInfo {
	@Autowired // 의존관계에 있는걸 자동적으로 달라붙게 만들어주기 위함
	private Student student;
	
}
