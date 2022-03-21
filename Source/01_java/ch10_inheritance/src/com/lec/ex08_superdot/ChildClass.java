package com.lec.ex08_superdot;

//super. : 내 부모단의
//super() : 내 부모단의 생성자 함수
public class ChildClass extends ParentClass { // ParentClass - i, method()
	private int i = 99; // 이렇게 정의하면 자식클래스의 i 정의가 됨

	public ChildClass() {
		System.out.println("ChildClass 생성자");
	}

	@Override
	public void method() {
		System.out.println("ChildClass의 method");
		super.method();
		System.out.println("ChildClass에서 super의 i=" + super.getI() + ", Child단의 i=" + i); // super.getI()를 써서 부모단의 I를 끌어올 수 있음
	}
	@Override
	public int getI() {
		return i;
	}
}
