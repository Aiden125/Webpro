package com.lec.ex;
//산술연산자 : + - * / %(나머지)
public class Ex01 {
	public static void main(String[] args) {
		int n1 = 33, n2=10;
		int result; // + - * %의 결과
		double resultdouble; // /의 결과
		//println 형태로 작성 해본 것
		result = n1 + n2;
		System.out.println(n1 + "+" + n2 + "=" +result);
		/*
		result = n1+n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result); // 33+10=43
		*/
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result);
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		result = n1 % n2; //나머지
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result);
		resultdouble = (double)n1 / n2;
		System.out.println(n1 + "/" + n2 + "=" +resultdouble);
		if(n1%2==0) {
			System.out.println("n1은 짝수");
			System.out.println("n1은 짝수라 좋아");
		}else
			System.out.println("n1은 홀수");
		if(n1%5==0){
			System.out.println("n1은 5의 배수");
		}else
			System.out.println("n1은 5의 배수가 아님");
	}
}
