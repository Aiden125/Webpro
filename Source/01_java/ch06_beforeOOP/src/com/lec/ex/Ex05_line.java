package com.lec.ex;

/*--------------
 * Hello, World!
 * ~~~~~~~~~~~~~
 * Hello, Java!
 * !!!!!!!!!!!!!
 * Hello, Hello!
 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 */
public class Ex05_line {
	public static void main(String[] args) {
		printline();
		System.out.println("Hello, World!");
		printline('~');
		System.out.println("Hello, Java!");
		printline(40);
		System.out.println("Hello, Hello!");
		printline('d',30);
	}
	private static void printline(char c, int cnt) {
		for(int i = 0 ; i<cnt ; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	private static void printline(char c ) {
		for(int i = 0 ; i<30 ; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	private static void printline(int cnt) {
		for(int i = 0 ; i<cnt ; i++) {
			System.out.print('-');
		}
		System.out.println();
	}
	private static void printline() { // 리턴타입이 없고 매개변수가 없는 메소드
		for(int i = 0 ; i<30 ; i++) {
			System.out.print('-');
		}
		System.out.println(); // 얇은 '-' 30개 출력하고 개행
	}
}
