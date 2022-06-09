package com.lec.loop;
// 2단부터 시작하는 구구단을 출력하는 프로그램을 구현해 보자
// 단, 한 단이 끝나면 문단을 바꾸어 표현하라
public class Quiz04 {
	public static void main(String[] args) {
		for(int i=1 ; i<10 ; i++) { // 1~9까지
			for(int j=2 ; j<10 ; j++) { // 2단부터 9단까지
				System.out.printf("%d * %d = %d\t", j, i, j*i);
			}
			System.out.println(); // 개행
		}
	}
}
		
		
// 스스로 작성한 코드		
// 			for(int i=2 ; i<=9 ; i++) {
//			for(int j=1 ; j<=10 ; j++) {
//				int tot = i*j;
//				if(j==10) {
//					System.out.println();
//				} else
//				System.out.print(i+"*"+j+'='+tot+"\t");
//			}
//			}
//		}
//	}