package com.st.operator;
// 나이를 입력받아 입력받은 나이가 65세 이상일 때, “경로우대” 출력, 아니면 “일반”출력
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("나이를 입력하세요 : ");
		int su = scanner.nextInt(); //사용자로부터 정수 입력 받기
		String result = su > 65 ? "경로우대" : "일반";
		System.out.println(result);
		scanner.close();
	}
}
