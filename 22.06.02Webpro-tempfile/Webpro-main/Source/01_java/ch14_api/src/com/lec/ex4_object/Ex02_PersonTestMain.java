package com.lec.ex4_object;
//equals를 써서 주소안에 포함한 값이 같은 값이면 같다고 판정시키고 싶은 경우.
//equals 오버라이딩 필요. Person 파일 함께 보기
public class Ex02_PersonTestMain {
	public static void main(String[] args) {
		Person p1 = new Person(9512051012121L);
		Person p2 = new Person(9512051012121L);
		Person p3 = null;
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		if(p1.equals(p2)) {
			System.out.println("p1과 p2는 같은 사람");
		}else {
			System.out.println("p1과 p2는 다른 사람");
		}
		System.out.println(p1.equals(p3)? "같아" : "달라");
		if(p1==p2) {
			System.out.println("p1과 p2는 같은 주소");
		}else {
			System.out.println("p1과 p2는 다른 주소");
		}
	}
}
