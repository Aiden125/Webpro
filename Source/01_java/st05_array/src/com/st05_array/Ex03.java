package com.st05_array;
// �迭�� ��� ���� ���ϴ� ���α׷� �ۼ�
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
