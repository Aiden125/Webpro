package com.lec.loop;

/*
 * 
 **
 ***
 ****
 */
public class Ex03_for {
	public static void main(String[] args) {
		for (int j = 1; j <= 5; j++) {// 5회반복(j가 1부터 5까지 반복)
			for (int i = 1; i <= j; i++) {// j회 반복(i가 1부터 j까지 반복)
				System.out.print('*');
			}
			System.out.println(); // 개행
		}
	}
}
