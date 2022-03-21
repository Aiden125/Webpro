package com.lec.ex08_superdot;
// ParentClass - i(private), method(), getI()
// ChildClass - i(private), method(), getI()
public class TestMain {
	public static void main(String[] args) {
		ChildClass child = new ChildClass();//ParentClass, ChildClass 생성자 출력
		System.out.println(child.getI());//99 출력(자식단의 getI) 부모클래스를 원하면 super.getI(); 를 부르는 method를 써야함
		child.method();
	}
}
