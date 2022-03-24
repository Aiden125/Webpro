package com.lec.ex07_friend;
// this. : 내 객체의
// this() : 현 클래스의 생성자 함수
public class Friend {
	private String name;
	private String tel; // 010의 맨 앞 0을 살리려면 꼭 String으로 해야함 Friend f = new Friend("홍길동");
	public Friend() {
		System.out.println("매개변수 없는 생성자 함수");
	}
	public Friend(String name) {
		this(); //Friend 호출. 만약 this(); 안쓰면 Friend 호출x
		this.name = name;
		System.out.println("매개변수 하나짜리 생성자 함수");
	}
	public Friend(String name, String tel) {
		this(name); //Friend(name) 호출. 만약 this(name)안쓰면 Friend 호출x
		this.tel = tel;
		System.out.println("매개변수 두 개 짜리 생성자 함수");
	}
	public String infoString() {
		return "[이름]"+name + " [전화]" + tel;
	}
}
