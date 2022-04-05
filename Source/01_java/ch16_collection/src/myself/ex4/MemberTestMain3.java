package myself.ex4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MemberTestMain3 {
	public static void main(String[] args) {
		HashMap<String, Member> map = new HashMap<String, Member>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("이름을 입력하세요 (중지는 N/n)");
			String name = sc.next();
			if(name.equalsIgnoreCase("n")) {
				break;
			}
			System.out.println("번호를 입력하세요");
			String tel = sc.next();
			System.out.println("주소를 입력하세요");
			sc.nextLine();
			String address = sc.nextLine();
			map.put(tel, new Member(name, tel, address));
		}
		if(map.isEmpty()) {
			System.out.println("가입된 회원이 없습니다.");
		}
		Iterator<String> iterator = map.keySet().iterator();
		if(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(map.get(key));
		}
		sc.close();
	}
}
