package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S s = new S();
		// A a = new A();
		S a = new A();//객체는 A로 만들었고, 변수의 타입은 S인 상황. 즉, 타입S인 변수a = 새로운 A객체로 지정할 것이다 라는 의미
		// B b = new B();
		S b = new B();//객체는 B로 만들었고, 변수의 타입은 S인 상황. 즉, 타입S인 변수b = 새로운 B객체로 지정할 것이다 라는 의미
		S c = new C();//객체는 C로 만들었고, 변수의 타입은 S인 상황. 즉, 타입S인 변수c = 새로운 C객체로 지정할 것이다 라는 의미
		//즉 A, B, C 객체의 타입이 모두 S가 된 상황 모두 S의 상속을 받기 때문이며, 반대로 부모를 자식 타입으로 변경은 불가
		S[] arr = {s, a, b, c};
		for(S obj : arr) {
			System.out.println(obj.s);
		}
	}
}
