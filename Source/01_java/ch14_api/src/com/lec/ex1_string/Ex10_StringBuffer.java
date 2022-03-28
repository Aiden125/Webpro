package com.lec.ex1_string;

public class Ex10_StringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		System.out.println(str.hashCode());
		str = str+"d";
		System.out.println(str.hashCode());
		
		StringBuilder strBuilder = new StringBuilder("abc");
		System.out.println("해시코드 결과 : "+strBuilder.hashCode());
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.append("def"); // 기존의 "abc"에 "def"를 추가 : abcdef
		System.out.println("strBuilder : "+strBuilder); // abcdef
		strBuilder.insert(3, "AAA"); // 3번째에 "AAA" 추가(인덱스 4번 위치)
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.delete(3, 5);//3번째부터 5번째 앞 까지 삭제해라
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.deleteCharAt(3); // 3번째 문자만 삭제 = delete(3,4)
		System.out.println("strBuilder : "+strBuilder);
		System.out.println("해시코드 결과 : "+strBuilder.hashCode());
	}
}
