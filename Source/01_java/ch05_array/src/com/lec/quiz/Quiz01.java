package com.lec.quiz;
// �迭�� ��� ���� ���ϴ� ���α׷��� �ۼ�
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
