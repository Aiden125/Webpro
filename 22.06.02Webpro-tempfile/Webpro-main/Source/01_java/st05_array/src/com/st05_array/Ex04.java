package com.st05_array;
//76,45,34,89,100,50,90,92  8개의 값을 1차원 배열로 초기화 하고 이들 값들을 크기 순으로 나타내는 프로그램
public class Ex04 {
	public static void main(String[] args) {
		int a[] = {76, 45, 34, 89, 100, 50, 90, 92};
		int b[] = new int[a.length]; //배열  a의 길이 만큼의 빈 공간을 정의.
		
		
		// 0으로 초기화 되어있던 배열 b를  a값으로 초기화
		for(int i=0 ; i<a.length ; i++) {
			b[i] = a[i];
			System.out.print(b[i]+" ");
		}
		
		// b에 a의 1,2열 값을 비교한 후 2가 작으면 교체.
		// 그냥 교체가 불가하기에  임의의 temp 정의 후 넣었다가 교체
		for(int i=0 ; i<a.length ; i++) {
			for(int j=1+i ; j<a.length ; j++) {
				if(b[j] < b[i]) {
					int temp = b[j];
					b[j] = b[i];
					b[i] = temp;
				}
			}
		}
		//for 확장문을 통한 반복 진행 b[]순차적으로 모두 출력 명령
		System.out.println("\n오름차순 테이터");
		for(int temp : b) {
			System.out.print(temp+" ");
		}
	}
}
