package com.lec.quiz;

//두 수 중 큰 수를 변수 max에 입력하고 변수 max를 출력하는 프로그램입니다. 잘못된 부분은?
//변수를 앞에 선언하는 방법이 있고 프린트를 매 괄호 안에 넣는 방법이 존재
public class Quiz02 {

	public static void main(String[] args) {
		int num1 = 27;
		int num2 = 32;
		int max;
		if (num1 > num2) {
			max = num1;
		} else {
			max = num2;
		}
		System.out.println(max);
	}
}
