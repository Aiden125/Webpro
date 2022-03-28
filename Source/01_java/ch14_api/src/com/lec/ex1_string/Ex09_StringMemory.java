package com.lec.ex1_string;
//스트링 변수는 값을 바꿀 때마다 객체가 새롭게 생성
public class Ex09_StringMemory {
	public static void main(String[] args) {
		//이미 완전히 동일한 문자열이 존재하면 이후에 만든 변수도 이전에 만든 주소를 가리킴
		String str1 = "Hello";
		String str2 = "Hello";
		System.out.println("str1의 해쉬코드 : "+str1.hashCode());
		System.out.println("str2의 해쉬코드 : "+str2.hashCode());
		str1 = "Hello~";
		System.out.println("str1의 해쉬코드(변경 1후) : "+str1.hashCode());
		str1 = "Hello~~";
		System.out.println("str1의 해쉬코드(변경 2후) : "+str1.hashCode());
		str1 = "Hello~~~";
		System.out.println("str1의 해쉬코드(변경 3후) : "+str1.hashCode());
	}
}
