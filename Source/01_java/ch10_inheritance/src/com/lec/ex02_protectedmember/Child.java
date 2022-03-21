package com.lec.ex02_protectedmember;

public class Child extends SuperIJ {
	private int total;

	public Child() {
		System.out.println("매개변수 없는 Child 생성자");
	}
	// Child c = new Child(10, 20);
	// 자식 클래스이지만 부모 클래스의 i, j 사용가능
	public Child(int i, int j) {
		setI(i);
		setJ(j);
		System.out.println("매개변수 있는 Child 생성자");
	}
	public void sum() {
		total = getI() + getJ(); // total = i+j; 만약 바로 i+j로 쓰면 오류. 받아와야하는 것이기 때문에
		System.out.printf("본 객체의 i=%d, j=%d", getI(), getJ());
		System.out.printf("본 객체의 total=%d", total);
	}
}
