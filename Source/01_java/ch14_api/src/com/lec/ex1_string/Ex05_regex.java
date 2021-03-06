package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05_regex {
	public static void main(String[] args) {
		String str = "010-2222-2222 moan125@naver.com (02)111-2222 반갑습니다. Hello 92122-1213121";
		
		// System.out.println("replace =>" + str.replace("0", "홍")); //0만 홍으로 바뀜,
		// 단순 replace를 쓸 때는 전화번호를 없애버려라, 한글을 없어버려라 이런식으로 쓰질 못함.
		// 정규표현식 간략 문법
		// 2.
		// \d(모든숫자) \D(숫자 제외한 모든 것) \s(whitespace 탭, 엔터, 스페이스)
		// \w(영문자나 숫자) \W(영문자나 숫자가 아닌 문자) .(문자하나)
		// +(1번이상)   *(0번이상)   ?(0~1번 반복)   {2,4}(2~4회 반복)
		// 3.
		// 연습장  ⓐhttps://regexr.com/   ⓑhttps://www.regexpal.com/
		// ex. 전화번호 : [(]?([0-9]){2,3}\D[0-9]{3,4}-[0-9]{4}
		//	       이메일 : \w+@\w+(.\w+){1,2} 문자나 숫자를 1번이상 반복+@문자나 숫자열을 1번이나 두번 반복
		// 4. 특정 정규표현식의 문장열 변경 : replaceAll("정규표현식", "대체문자열")
		
		//System.out.println(str.replaceAll("[0-9]",  "x")); // 숫자를 x로 바꿔라
		// System.out.println(str.replaceAll("\\d",  "x")); // 역슬래시를 표현하려면 두개써야함 숫자를 x로 바꿔라
		//System.out.println(str.replaceAll("\\D",  "x")); // 숫자가 아닌것(스페이스도 포함해 없애버림)
		
		//전화번호 지우는 방법
		System.out.println(str.replaceAll("[(]?([0-9]){2,3}\\D[0-9]{3,4}-[0-9]{4}", "**전화번호 지움**"));
		//이메일 지우는 방법
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "**이메일 지움**"));
		//알파벳 대신 *로 대체
		System.out.println(str.replaceAll("[a-zA-Z]", "*"));
		//한글 싹 다 없애
		System.out.println(str.replaceAll("[가-힣ㄱ-ㅎ]", "한글"));
		//주민번호 뒷자리를 *로 대체
		System.out.println(str.replaceAll("[0-9]{7}", "*******")); //[0-9]{7} 숫자를 7번 반복하는 곳이라는 의미
		
		
		
		

	}
}
