package com.lec.ex1_string;

import java.util.Scanner;

public class Ex03_equal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fn;
		do {
			System.out.println("I : input | U : update | X : exit");
			fn = scanner.next(); // XxIiUu, etc
			switch(fn) {
			// i혹은 I입력하는 경우
			case "i":
			case "I":
				System.out.println("input 로직 있을 곳");
				break;
			
			// u혹은 U 입력하는 경우
			case "u":
			case "U":
				System.out.println("update 로직 있을 곳");
			}
		}while(!fn.equalsIgnoreCase("x")); //x 혹은 X를 입력하지 않으면 계속 반복. 둘중 하나를 입력하면 빠져나옴
		System.out.println("DONE");
	}
}
