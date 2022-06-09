package com.lec.ex08_superdot;
// super. : 내 부모단의
// super() : 내 부모단의 생성자 함수 - 특히 빈도가 높기에 꼭 알아두기
public class ParentClass {
	private int i = 20;
	public ParentClass() {
		System.out.println("ParentClass 생성자");
	}
	public void method() {
		System.out.println("ParentClass의 method super단의 아이는 i는 "+i);
	}
	//i가 private로 선언되어있기에 getI를 통해 리턴값을 받아와야 함
	public int getI() {
		return i;
	}
}