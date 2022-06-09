package com.lec.ex01_parentchild;

public class ParentClass {
	String pStr = "부모클래스"; // public 선언 안하면 default로 선언됨
	public ParentClass() {
		System.out.println("부모클래스 객체 부분 생성");
	}
	public void getPapaName() {
		System.out.println("아빠이름 : 홍길동");
	}
	public void getMamiName() {
		System.out.println("엄마 이름 : 이길순");
	}
}
