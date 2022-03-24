package com.st.loop;
//2단부터 시작하는 구구단을 출력하는 프로그램을 구현해 보자
//단, 한 단이 끝나면 문단을 바꾸어 표현하라
public class Ex02_for2 {
	public static void main(String[] args) {
		for(int i=1 ; i<10 ; i++) { // 1~9까지
			for(int j=2 ; j<10 ; j++) { // 2단부터 9단까지
				System.out.printf("%d * %d = %d\t", j, i, j*i);
			}
			System.out.println(); // 개행
		}
	}
}