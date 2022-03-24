package com.lec.method;

public class Arithmetic {
	public int abs(int value) {
		int result = (value >= 0) ? value : -value;
		return result;
	}

	public static int sum(int to) { // 함수의 오버로딩 똑같은 함수명인데 매개변수의 타입이나 갯수를 달리해서 하는 것
		int result = 0;
		for (int i = 1; i <= to; i++) {
			result += i;
		}
		return result;
	}

	public static int sum(int from, int to) {// from~to까지 누적한 결과 return
		int result = 0;
		for (int i = from; i <= to; i++) {
			result += i;
		}
		return result;
	}

	public static String evenOdd(int value) {
		return value % 2 == 0 ? "짝수입니다" : "홀수입니다";
	}
}
