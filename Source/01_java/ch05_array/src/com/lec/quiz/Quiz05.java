package com.lec.quiz;

// 76,45,34,89,100,50,90,92  8개의 값을 1차원 배열로 초기화 하고 이들 값들을 크기 순으로 나타내는 프로그램을 작성 하시오.
// 
public class Quiz05 {
	public static void main(String[] args) {
		int arr[] = { 76, 45, 34, 89, 100, 50, 90, 92 };
		int[] sortArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			sortArr[i] = arr[i];
		}
		// 오름차순 정렬 : Arrays.sort(sortArr);
		for (int i = 0; i < sortArr.length; i++) {// i=0~8까지
			for(int j=i+1 ; j < sortArr.length; j++) { // j=i+7까지
				// i번째와 j번째 비교해서 i번째가 크면 교환
				if(sortArr[i] > sortArr[j]) {
					int temp = sortArr[i];
					sortArr[i] = sortArr[j];
					sortArr[j] = temp;
				}//1f 교환
			}//for-j
		}//for-i
		System.out.print("원 데이터 :");
		for(int temp : arr) {
			System.out.print(temp+" ");
		}
		System.out.print("\n오름차순 정렬 데이터 :");
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