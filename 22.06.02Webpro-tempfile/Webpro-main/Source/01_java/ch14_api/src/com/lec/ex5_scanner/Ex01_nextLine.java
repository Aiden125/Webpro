package com.lec.ex5_scanner;
import java.util.Scanner;
//요약 - buffer란 입력받는 공간
//nextInt(); -> 숫자 받는 거
//next(); -> String 받는 거 but, 공백 포함이 안됨
//nextLine(); -> String 받는 거(공백포함) but, 앞선 실행식에서 \n 남아있는 거 꼭 체크하고 지워줘야함.
public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = scanner.nextInt(); // '\n' 앞의 숫자를 return하고 버퍼를 지움
		System.out.println("입력하신 나이는"+age);
		
		System.out.print("이름을 입력하세요");
		String name = scanner.next(); //반드시 스페이스가 안들어가게 입력해줘야 실행 가능 스캐너.next는 첫번째 빈공간 앞까지만 출력
		System.out.println("입력하신 이름은"+name);
		
		System.out.println("주소를 입력하세요 :");
		//바로 아래 라인을 넣냐 안넣냐의 따라서 오류가 발생하냐 안하냐가 갈라짐
		scanner.nextLine(); // 버터에 남아있는 \n을 지우는 목적
		//
		String address = scanner.nextLine(); // 엔터를 치기까지 값을 return
		System.out.println("입력하신 주소는"+address);
		scanner.close();
	}
	//해당식의 경우 스캐너 인트실행시 2 0 \n 실행. 20값 리턴 엔터값 남음
	//네임스캐너의 경우 \n 홍 길 동 \n 이 실행되면 앞에 있는 \n을 무시하고 홍 길 동 만리턴하고 마지막 \n이 남게 됨
	//현재 \n이 하나 남아 있는 상황이며, 스캐너 넥스트라인의 경우 \n의 앞에껄 리턴하기 때문에 아무것도 리턴이 안됨 즉, 위에서 되물려온 \n를 지워줘야함
}
