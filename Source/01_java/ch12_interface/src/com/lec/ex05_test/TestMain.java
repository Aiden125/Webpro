package com.lec.ex05_test;

public class TestMain {
	public static void main(String[] args) {
		TestChildClass obj = new TestChildClass();
		obj.m1();
		obj.m2();
		obj.m3();
		obj.m11();
		System.out.println(I11.i11); //static final 변수는 이런식으로 모든 주소 쓰는것을 추천
		System.out.println(I3.i1);
	}
}
