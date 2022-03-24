package com.lec.ex06_override;
//꼭 상속을 같은 패키지에 할 필요는 없지만 import는 꼭 해줘야 함
public class ParentClass {

	public ParentClass() {//오버로딩 ParentClass가 중복되어있음(매개변수의 수나 타입을 달리하면서)
		System.out.println("매개변수 없는 ParentClass 생성자");
	}
	public ParentClass(int i) {//오버로딩 ParentClass가 중복되어있음(매개변수의 수나 타입을 달리하면서)
		System.out.println("매개변수 있는 ParentClass 생성자");
	}
	public void method1() {
		System.out.println("ParentClass의 method1()의 함수");
	}
	public void method2() {
		System.out.println("ParentClass의 method2()의 함수");
	}
}
