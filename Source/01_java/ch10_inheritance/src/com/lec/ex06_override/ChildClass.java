package com.lec.ex06_override;
// ParentClass의 method1(), method2()상속 받음
// 만약 method1()를 상속 받는데 이걸 이 ChildClass에서만 뭔가 바꾸고 싶을 때
public class ChildClass extends ParentClass {
	public ChildClass() {//ChildClass 오버로딩 상태
		System.out.println("매개변수 없는 ChildClass 생성자");
	}
	public ChildClass(int i) {//ChildClass 오버로딩 상태
		System.out.println("매개변수 있는 ChildClass 생성자");
	}
	public void method3() {
		System.out.println("ChildClass의 method3() 함수");
	}
	@Override
	public void method1() {//ParentClass의 method1 오버라이드
		System.out.println("ChildClass의 method1() 오버라이드");
	}
	@Override
	public boolean equals(Object obj) { // object 클래스의 equals 오버라이드(바로 위 클래스가 아닌 위위클래스도 가능하다는 의미)
		return true;
	}
}
