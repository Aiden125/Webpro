package com.lec.quiz;

//������ ����3) 76,45,34,89,100,50,90,92  8���� ����
//1���� �迭�� �ʱ�ȭ �ϰ� ���� �հ��  ��� �׸��� �ִ밪�� �ּҰ��� ���ϴ� ���α׷��� �ۼ� �Ͻÿ�
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
		System.out.println("�հ� ����" + sum);
		System.out.println("��� ����" + sum / (double) arr.length);
		System.out.println("�ִ� ����" + max);
		System.out.println("�ּ� ����" + min);
	}
}
