package com.lec.ex3_exceptionExs;

public class Ex03_numberformat {
	public static void main(String[] args) {
		//int i = Integer.parseInt(""); //빈스트링은 숫자로 변환 안되며, 예외발생
		int i = Integer.parseInt("100 ".trim()); //스트링안에 스페이스가 들어가도 마찬가지로 안되기 때문에 트림이용
		System.out.println(i);
	}
}
