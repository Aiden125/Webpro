package com.lec.ex1_string;

public class Ex02_stringAPImethod {
	public static void main(String[] args) {
		boolean searok = true;
		boolean searak = true;
		System.out.println(searok == searak? "같다" : "다르다");
		
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "                       ja  va         ";
		System.out.println("1번 값 "+str1.concat(str2)); // 문자열결합 함수를 더하는 것 abcXabcABCXabc
		System.out.println("2번 값 "+str1.substring(3)); // 3번째부터 끝까지 Xabc
		System.out.println("3번 값 "+str1.substring(3,5)); // 3번째부터 5번째앞까지Xa
		System.out.println("4번 값 "+str1.length()); //글자길이7
		System.out.println("5번 값 "+str1.toUpperCase()); //대문자로 ABCXABC
		System.out.println("6번 값 "+str1.toLowerCase()); //소문자로 abcxabc
		System.out.println("7번 값 "+str1.charAt(3)); //3번째 문자를 반환 'X'
		System.out.println("8번 값 "+str1.indexOf('b')); //첫번째 b문자가 나오는 위치의 인덱스
		System.out.println("9번 값 "+str1.indexOf('b', 3)); //3번째부터 검색해서 첫번째'b'위치 인덱스 5 (인덱스는 처음부터시작)
		System.out.println("10번 값 "+str1.indexOf("abc")); //첫번째 "abc" 나오는 위치 인덱스 0
		System.out.println("11번 값 "+str1.indexOf("abc", 3)); //3번째부터 검색해서 첫번째 "abc" 나오는 위치인덱스 4(인덱스는 처음부터시작)
		System.out.println("12번 값 "+str1.indexOf('z')); //없으면 -1
		System.out.println("13번 값 "+str1.lastIndexOf('b')); //마지막'b'위치 반환
		System.out.println("14번 값 "+str1.lastIndexOf('b',3)); //3번째부터 맨 마지막 b
		
		System.out.println("15번 : "+str1.equals(str2)); //str1과 str2가 같은 문자열인지 false
		System.out.println("16번 : "+str1.equalsIgnoreCase(str2)); //대소문자 구분없이 비교 true
		System.out.println("17번 : "+str3.trim()); //앞뒤 공백제거. 중간공백은 제거x
		System.out.println("18번 : "+str1.replace('a', '9')); //'a'를 '9'로 수정 9bcX9bc
		System.out.println("19번 : "+str1.replace("abc", "ㅁㅁㅁ")); //"abc"을 "ㅁㅁㅁ"로 수정
		System.out.println("20번 : "+str3.replace(" ", "")); // 공백을 없앨 때
		System.out.println("21번 : "+str1.replaceAll("abc", "ZZZ")); // "abc"를 "ZZZ"로
		
		//정규표현식 https://goo.gl/Hlntbd
		//정규표현식 연습장 https://www.nextree.co.kr/p4327
		String str = "안녕Hello";
		System.out.println(str.replaceAll("[a-zA-Z]", ""));//알파벳을 ""로 수정
		System.out.println(str.replaceAll("[가-힣]", ""));//한글문자를 ""로 수정
		//문자열 메소드는 문자열을 수정 안함
		System.out.println("stsr1 = "+str1);
		System.out.println("stsr2 = "+str2);
		System.out.println("stsr3 = "+str3);
	}
}
