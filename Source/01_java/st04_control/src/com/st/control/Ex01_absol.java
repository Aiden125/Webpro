package com.st.control;

import java.util.Scanner;

public class Ex01_absol {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1;
		System.out.println("수를 입력하시오");
		num1 = sc.nextInt();
		if(num1>=0) {
			System.out.println(num1);
		}else {
			System.out.println(-num1);
		}
		sc.close();
	}
}
