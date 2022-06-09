package com.lec.ex5_scanner;
import java.util.Scanner;
// 버퍼라는 것은 공유공간이기 때문에 메인함수에서 한번만 닫아야됨 메소드든 어디든 두번 닫게되면 그 공간을 완전히 닫아버리기에
// 다시 쓸 수 없게됨
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
	private static void nickName() { //사용자로부터 별명을 받아 출력하는 method
		Scanner scNickName = new Scanner(System.in);
		System.out.println("What's your NickName?");
		System.out.println("Your NickName is : "+scNickName.nextLine());
		//scNickName.close(); //버퍼를 여기서 닫게되면 버퍼가 완전히 닫힘
	}
}
