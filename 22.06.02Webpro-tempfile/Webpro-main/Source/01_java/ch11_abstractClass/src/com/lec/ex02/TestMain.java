package com.lec.ex02;

public class TestMain {
	public static void main(String[] args) { //추상 클래스를 타입으로 설정한 경우
		SuperClass obj = new ChildClass();
		obj.method1();
		obj.method2();
	}
}
		
		
		//추상 클래스는 객체 생성을 못하기에 익명타입으로 설정하는거 아니면 안됨. 타입으로 설정은 가능
//		SuperClass s = new SuperClass() {
//			@Override
//			public void method1() {
//				System.out.println("익명클래스 생성");
//			}
//		};
//		s.method1();
