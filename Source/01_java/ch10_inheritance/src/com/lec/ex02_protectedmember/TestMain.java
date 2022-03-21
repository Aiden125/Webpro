package com.lec.ex02_protectedmember;

public class TestMain {
	public static void main(String[] args) {
		Child child = new Child(1, 2);
		System.out.println("child의 i :"+child.getI()); //get이용 값 받아오기
		System.out.println("child의 j :"+child.getJ()); //get이용 값 받아오기
		child.setI(10);;child.setJ(20); // set이용 새로 초기화 시키기
		child.sum();
	}
}
