package com.lec.loop;
// 1부터 100까지 3의 배수의 합만 누적한 결과값을 구하시오
public class Ex07_forwhile {
	public static void main(String[] args) {
		int sum = 0;
		int i=1;
		while(i<101) {
			if(i%3==0) {
				sum += i;
			}
			++i;
		}
		System.out.println("3의 배수 누적 합은"+sum+"입니다");
	}
}
		
		
		
		
		
				
//		int sum = 0;
//		for(int i=1 ; i<101 ; i++) {
//			if(i%3 ==0) {
//				sum += i; // sum = sum+i;
//			} // if
//		} // for
//		System.out.println("누적합은"+sum);
//	}
//}
