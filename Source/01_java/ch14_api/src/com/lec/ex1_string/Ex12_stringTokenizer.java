package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex12_stringTokenizer {
	public static void main(String[] args) {
		String str1 = "박보검 설현 수지 아이유 허각";
		String str2 = "2022/03/28";
		StringTokenizer tokenizer1 = new StringTokenizer(str1); //토큰화를 시키는 객체(괄호안에 토큰화를 시키고 싶은 개체 넣기) space를 기준으로 문자열 분열
		System.out.println("tokenizer1의 토큰 갯수 : "+tokenizer1.countTokens());
		while(tokenizer1.hasMoreTokens()) {
			System.out.println(tokenizer1.nextToken()); // 
		}
		StringTokenizer tokenizer2 = new StringTokenizer(str2, "/"); //내가 원하는 문자가 있다면 객체, 문자 이런식으로 잡을 것 현재 슬래시로 구분. 스트링으로 분할시킴
		System.out.println("tokenizer2의 토큰 갯수 : "+tokenizer2.countTokens());
		while(tokenizer2.hasMoreTokens()) {
			System.out.println(tokenizer2.nextToken());
		}
	}
}
