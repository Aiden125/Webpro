package st1_api;

import java.util.Scanner;

public class FriendTestMain {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("홍길동", "010-9999-9999", "05-22"),
				new Friend("신길동", "010-8888-8888", "09-22"),
				new Friend("마길동", "010-8888-9999", "08-22"),
				new Friend("윤길동", "010-7777-7777", "04-22"),
				new Friend("김길동", "010-6666-7777", "03-22") };
		
		// boolean값 변수 새로 지정
		// 사용자에게 받을 변수 새로 지정
		Scanner sc = new Scanner(System.in);
		while (true) {
			String su;
			System.out.println("전화번호 뒷 자리를 입력하시오");
			su = sc.next();
			if (su.equals("x"))
				break;
			boolean suOk = false;
			for (int idx = 0; idx < friends.length; idx++) {
				String phone = friends[idx].getPhone();
				String back = phone.substring(phone.lastIndexOf('-') + 1);
				if (back.equals(su)) {
					System.out.println(friends[idx]);
					suOk = true;
				}//if
			}//for
			if (!suOk) {
				System.out.println("검색하신 친구는 조회되지 않습니다");
			}
		}sc.close();
	}
}
