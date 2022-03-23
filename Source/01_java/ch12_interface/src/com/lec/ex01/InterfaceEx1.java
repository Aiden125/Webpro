package com.lec.ex01;
// 상수(final 변수), 추상메소드만 가능
// 생성자 불가.
public interface InterfaceEx1 {
	//아래 문장에서 static final 생략가능(인터페이스 파일 안에서만)
	public static final int CONSTANT_NUM = 10;
	
	//아래 문장에서 abstract 생략가능(인터페이스 파일 안에서만)
	public abstract void method1();
}
