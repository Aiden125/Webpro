package com.lec.quiz;

//오늘의 문제3) 76,45,34,89,100,50,90,92  8개의 값을
//1차원 배열로 초기화 하고 값에 합계와  평균 그리고 최대값과 최소값을 구하는 프로그램을 작성 하시오
public class Quiz03 {
	public static void main(String[] args) {
		int arr[] = { 76, 45, 34, 89, 100, 50, 90, 92 };
		int sum = 0;
		int min = 999;
		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
			sum = sum + arr[i];
		}
		System.out.println("합계 값은" + sum);
		System.out.println("평균 값은" + sum / (double) arr.length);
		System.out.println("최대 값은" + max);
		System.out.println("최소 값은" + min);
	}
}
