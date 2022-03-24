package com.lec.ex02;
// method1(추상메소드), method2(일반메소드)
public abstract class ChildClass2 extends SuperClass{ //만약 추상 상속을 받았는데 오버라이드 하기 싫으면 얘도 추상으로 하면됨
	@Override
	public void method2() {
		System.out.println("ChildClass의 method2 - 그냥 오버라이드 해봄");
	};
}
