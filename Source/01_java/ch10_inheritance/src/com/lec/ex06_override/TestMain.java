package com.lec.ex06_override;

public class TestMain {
	public static void main(String[] args) {
		ParentClass pObj1 = new ParentClass();
		//매개 없는 parent생성자
		ParentClass pObj2 = new ParentClass(1);
		//매개변수 있는 parent생성자
		if(pObj1.equals(pObj2)) {
			System.out.println("두 객체는 같다.");
		}else {
			System.out.println("두 객체는 다르다.");
		}
		//두 객체는 다르다
		ChildClass cObj = new ChildClass(2);
		//매개변수 없는 parent 생성자
		//매개변수 있는 차일드클래스 생성자
		if(cObj.equals(pObj2)) {
			System.out.println("무조건 true지");
		}
		//생성oo
		pObj1.method1();
		//parent method1
		pObj1.method2();
		//parent method2
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		cObj.method1(); // ChildClass의 method1
		cObj.method2(); // ParentClass의 method2
		cObj.method3(); // ChildClass의 method3
		ParentClass cObj1 = new ChildClass(2);
		//매개변수 없는 parent 생성자
		//매개변수 있는 Child 생성자
		cObj1.method1(); // ChildClass의 method1
		cObj1.method2(); // ParentClass의 method2
		//ParentClass형 cObj1변수를 ChildClass형으로 변환 가능? )
		if(cObj1 instanceof ChildClass) {
			((ChildClass)cObj1).method3();	
		}else {
			System.out.println("형 변환 안됨");
		}
	}//main
}//class
