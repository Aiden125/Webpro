package com.lec.ex05;

public class Child2 extends Super {
	int c2;
	public Child2() {
		System.out.println("Child2형 객체 생성");
	}
	public Child2(int c2) {
		System.out.println("매개 변수 있는Child2형 객체 생성");
		this.c2 = c2;
	}	
}