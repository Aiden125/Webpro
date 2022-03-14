package com.lec.loop;
// while을 활용해 10. 9. 8. ~ 2. 1. 출력
public class Ex06_while {
	public static void main(String[] args) {
		int i=10;
		while(i>=1) {
			System.out.println(i+". ");
			--i;
		}
		
		// for문으로 하는 경우
//		for(int i=10 ; i>=1 ; i--) {
//			System.out.print(i+".");
		}
	}
