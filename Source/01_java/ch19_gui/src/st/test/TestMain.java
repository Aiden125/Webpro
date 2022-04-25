package st.test;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer;
		boolean ok = false;

		Friend[] friends = {
				new Friend("홍길동", "서울시 용산구", "010-9999-1234", "05-22"),
				new Friend("마길동", "경기도 용인시", "010-7777-1234", "04-08"),
				new Friend("박길동", "서울시 강남구", "010-6666-1234", "12-05") };

		while (true) {
			System.out.println("검색할 주소 앞 글자 2자리(단, 종료를 원하시면 x를 입력하시오)");
			answer = sc.next();
			if (answer.equalsIgnoreCase("x")) {
				break;
			}
			for (Friend f : friends) {
				String spad = f.getAddress().substring(0, 2);
				if (answer.equals(spad)) {
					System.out.println(f);
					ok = true;
				} 
			}if(!ok) {
				System.out.println("검색하신 주소의 친구는 없습니다."+"\n");				
			}
		}
		sc.close();
	}
}
