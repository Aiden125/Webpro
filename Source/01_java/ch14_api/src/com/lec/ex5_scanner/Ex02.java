package com.lec.ex5_scanner;
import java.util.Scanner;
//버퍼를 지워야하는지 마는지만 판단해서 nextLine한번 더 넣어서 \n지워주면 되고
//안지워도 되는 경우라면 딱 필요한 만큼만 넣어야 안 꼬임
public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("주소를 입력하세요");
		scanner.nextLine();
		String address = scanner.nextLine();
		System.out.println("입력하신 주소는" + address);
		
		System.out.println("이름을 입력하세요");
		String name = scanner.next();
		System.out.println("입력하신 이름은 " + name);
	}
}
