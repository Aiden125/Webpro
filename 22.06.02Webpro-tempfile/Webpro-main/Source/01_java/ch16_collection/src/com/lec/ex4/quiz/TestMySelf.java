package com.lec.ex4.quiz;
//test1, 2합쳐서 전화번호도 중복되면 종료되는 arraylist만들어보기
import java.util.ArrayList;
import java.util.Scanner;

public class TestMySelf {
	public static void main(String[] args) {
		ArrayList<Member> member = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("이름을 입력해주세요 (중지는N/n)");
			String name = sc.next();
			
			if(name.equalsIgnoreCase("n")) {
				System.out.println("종료합니다");
				break;
			}
			System.out.println("번호를 입력해주세요");
			String tel = sc.next();
			//중복된걸 제거하려면 하나씩 대조해서 찾아내야함. 
			//Map에서 쓰는 비효율적인 방법과 동일한 방법이지만 가능은 함
			if
			System.out.println("주소를 입력해주세요");
		}
	}
}

//파일의 입출력
//정보 가져올 때(입력-읽어들이기) 스트림 연결 후 다 가져오면 스트림 연결 끊고(스트림을 닫는다)
//정보를 내보낼 때(출력-내보내기) 파일로 스트림 연결하고 파일 쭉 보내고 연결 끊고(스트림을 닫는다)