package com.st05_array;

public class Ex01_array_for {
	public static void main(String[] args) {
		int[] arr = new int[3]; // 0 0 0으로 초기화 됨{0 0 0} 과 같음
		for(int idx=0 ; idx<arr.length ; idx++) { // 일반 for문 이용한 출력
			System.out.printf("arr[%d]=%d\n", idx, arr[idx]);
		}
		for(int temp : arr) { //확장 for문을 이용한 출력
			System.out.println(temp);
		}
		for(int i=0 ; i<arr.length ; i++) { // 일반 for문을 이용한 배열 수정
			arr[i] = 5;
		}
		for(int temp : arr) { // 확장 for문을 이용한 배열 수정 불가능(배열이 결국 그대로 고정이기에)
			temp = 9;
		}
		
		for(int temp : arr) { // 확장 for문을 이용한 출력 arr값이 안바뀌기 때문에 원래 지정한 5값이 그대로 출력되는게 정상
			System.out.println(temp);
		}
	}
}
