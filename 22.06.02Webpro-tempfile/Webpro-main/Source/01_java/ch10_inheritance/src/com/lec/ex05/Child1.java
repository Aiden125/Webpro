package com.lec.ex05;

public class Child1 extends Super {
	int c1;
	public Child1() {
		System.out.println("Child1형 객체 생성");
	}
	public Child1(int c1) {
		System.out.println("매개 변수 있는Child1형 객체 생성");
		this.c1 = c1;
	}
}
