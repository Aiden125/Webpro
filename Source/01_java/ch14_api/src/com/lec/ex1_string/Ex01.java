package com.lec.ex1_string;

public class Ex01 {
	public static void main(String[] args) {
		String str1 = "Java";
		String str2 = "Java";
		// String은 new로 생성하지 않고 " "를 사용한 문자열 상수를 이용. 자동으로 힙영역에 String 객체가 이미 존재하는지 확인하고
		// 존재하면 이미 존재하는 주소를 가리킴. 존재하지 않으면 String 객체 생성. new하면 무조건 만들어 주기는 함
		String str3 = new String("Java"); //무조건 생성(new 이기 때문에)
		if(str1==str2) {
			System.out.println("str1과 str2는 같은 주소값");
		}else {
			System.out.println("str1과 str2는 다른 주소값");
		}
		if(str1.equals(str2)) {
			System.out.println("같은 물자열");
		}
		System.out.println(str1==str3? "str1과 3은 같은 주소":"str1과 3은 다른주소");
		System.out.println(str2.equals(str3)? "같은 스트링" : "다른 스트링");
		
	}
}
