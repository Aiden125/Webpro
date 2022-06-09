package com.lec.ex01;

public class TestMain {
	public static void main(String[] args) {
//		InterfaceEx1 ex1 = new InterfaceEx1() {//인터페이스 객체 생성 불가
		InterfaceClass obj1 = new InterfaceClass(); // new Inter는 객체
		obj1.method1();
		obj1.method2();
		
//		객체변수로 static access 비추천(바로 아래 방법)
//		System.out.println(obj1.CONSTANT_NUM+"/"+obj1.CONSTANT_STRING); 
		System.out.println(InterfaceEx1.CONSTANT_NUM+"/"+InterfaceEx2.CONSTANT_STRING);
		
		InterfaceEx1 obj2 = new InterfaceClass();
		obj2.method1();
		if(obj2 instanceof InterfaceClass) {
			((InterfaceClass)obj2).method2();
		}
		//형 변환 필요함
//		System.out.println(obj2.CONSTANT_STRING);
		InterfaceEx2 obj3 = new InterfaceClass();
		//obj3.method1();
		obj3.method2();
	}
}
