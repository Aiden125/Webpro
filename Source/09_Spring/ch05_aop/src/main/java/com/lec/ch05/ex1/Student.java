package com.lec.ch05.ex1;

import javax.xml.bind.annotation.XmlInlineBinaryData;

import lombok.Data;

@Data
public class Student {
	private String name;
	private int age;
	private int gradeNum;
	private int classNum;
	
	public void getStudentInfo() { // 호출될 핵심기능 메서드(타겟 메서드) = 비지니스 로직
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("학년 : " + gradeNum);
		System.out.println("반 : " + classNum);
	}
}
