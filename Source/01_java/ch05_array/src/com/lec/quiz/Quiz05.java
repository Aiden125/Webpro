package com.lec.quiz;

// 76,45,34,89,100,50,90,92  8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� �̵� ������ ũ�� ������ ��Ÿ���� ���α׷��� �ۼ� �Ͻÿ�.
// 
public class Quiz05 {
	public static void main(String[] args) {
		int arr[] = { 76, 45, 34, 89, 100, 50, 90, 92 };
		int[] sortArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			sortArr[i] = arr[i];
		}
		// �������� ���� : Arrays.sort(sortArr);
		for (int i = 0; i < sortArr.length; i++) {// i=0~8����
			for(int j=i+1 ; j < sortArr.length; j++) { // j=i+7����
				// i��°�� j��° ���ؼ� i��°�� ũ�� ��ȯ
				if(sortArr[i] > sortArr[j]) {
					int temp = sortArr[i];
					sortArr[i] = sortArr[j];
					sortArr[j] = temp;
				}//1f ��ȯ
			}//for-j
		}//for-i
		System.out.print("�� ������ :");
		for(int temp : arr) {
			System.out.print(temp+" ");
		}
		System.out.print("\n�������� ���� ������ :");
		for(int temp : sortArr) {
			System.out.print(temp+" ");
		}
	}
}
//int temp;
//
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr.length; j++) {
//				if (arr[j] > arr[i]) {
//					temp = arr[j];
//					arr[j] = arr[i];
//					arr[i] = temp;
//				}
//			}
//		}
//		for (int k = 0; k < arr.length; k++) {
//			System.out.print(arr[k] + "\t");
//		}