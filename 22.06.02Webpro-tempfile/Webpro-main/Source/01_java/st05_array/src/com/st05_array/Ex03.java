package com.st05_array;
// 배열에 담긴 값을 더하는 프로그램 작성
// int[] arr = {10, 20, 30, 40, 50}
public class Ex03 {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		for(int temp : arr) {
			sum += temp;
		}
		System.out.println(sum);
	}
}
