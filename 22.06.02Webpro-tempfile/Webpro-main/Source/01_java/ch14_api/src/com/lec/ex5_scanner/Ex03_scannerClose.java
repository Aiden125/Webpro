package com.lec.ex5_scanner;
import java.util.Scanner;
// ���۶�� ���� ���������̱� ������ �����Լ����� �ѹ��� �ݾƾߵ� �޼ҵ�� ���� �ι� �ݰԵǸ� �� ������ ������ �ݾƹ����⿡
// �ٽ� �� �� ���Ե�
public class Ex03_scannerClose {
	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.println("What's your name?");
		String name = scMain.nextLine();
		System.out.println("your name is : "+name);
		nickName();
		System.out.println("age? ");
		int age = scMain.nextInt();
		System.out.println("Your age is : "+age);
		scMain.close();
	}
	private static void nickName() { //����ڷκ��� ������ �޾� ����ϴ� method
		Scanner scNickName = new Scanner(System.in);
		System.out.println("What's your NickName?");
		System.out.println("Your NickName is : "+scNickName.nextLine());
		//scNickName.close(); //���۸� ���⼭ �ݰԵǸ� ���۰� ������ ����
	}
}
