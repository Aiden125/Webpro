package com.lec.ch05.ex1;

import lombok.Data;

@Data
public class Worker {
	private String name;
	private int age;
	private String job;
	
	public void getWorkerInfo() { // 핵심 기능 (= 타겟 메소드 = 비지니스로직)
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("직업 : " + job);
	}
}
