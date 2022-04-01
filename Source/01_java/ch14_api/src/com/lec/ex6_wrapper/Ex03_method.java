package com.lec.ex6_wrapper;

public class Ex03_method {
	public static void main(String[] args) {
		System.out.println("스트링을 정수로 바꾸는 함수 : Integer.parseInt(문자열)");
		// 내가 원하는게 이런거 일 때 int i = "10"; 즉, 스트링10을 입력해도 정수i로 만들고 싶을 때
		int i = Integer.parseInt("10");
		System.out.println(i);
		System.out.println("정수를 스트링으로 바꾸는 함수 : ");
		// 내가 원하는 게 이런거 일 때 String monthStr = 12;
		String monthStr = ""+12; //이렇게도 가능은 함. 스트링+정수 == 스트링 이기 때문에
		monthStr = String.valueOf(12); //이게 정석
		System.out.println(monthStr);
	}
}
