package com.lec.quiz;
// 배열에 담긴 값을 더하는 프로그램을 작성
public class Quiz01 {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		for(int index=0 ; index<arr.length ; index++) {
			sum = sum+arr[index];
		}
		for(int temp : arr) {
			sum += temp;
		}
		System.out.println(sum);
	}
}
