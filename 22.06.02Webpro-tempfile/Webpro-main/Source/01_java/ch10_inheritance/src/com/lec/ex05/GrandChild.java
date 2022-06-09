package com.lec.ex05;

public class GrandChild extends Child1 {
	int gc;

	public GrandChild() {
		System.out.println("GrandChild형 객체 생성");
	}

	public GrandChild(int gc) {
		System.out.println("매개 변수 1개 있는GrandChild형 객체 생성");
		this.gc = gc;
	}
}
