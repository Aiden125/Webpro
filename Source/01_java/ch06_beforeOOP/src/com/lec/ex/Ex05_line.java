package com.lec.ex;

/*--------------
 * Hello, World!
 * ~~~~~~~~~~~~~
 * Hello, Java!
 * !!!!!!!!!!!!!
 * Hello, Hello!
 * �ѤѤѤѤѤѤѤѤѤ�
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
	private static void printline() { // ����Ÿ���� ���� �Ű������� ���� �޼ҵ�
		for(int i = 0 ; i<30 ; i++) {
			System.out.print('-');
		}
		System.out.println(); // ���� '-' 30�� ����ϰ� ����
	}
}
