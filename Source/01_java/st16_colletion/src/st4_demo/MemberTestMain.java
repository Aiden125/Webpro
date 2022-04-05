package st4_demo;

import java.util.ArrayList;
import java.util.Scanner;
// 데이터를 ArrayList에 넣고 출력
public class MemberTestMain {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		String answer;
		
		while(true) {
			System.out.println("회원가입을 하시겠습니까? Y/N");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				break;
			}else if(answer.equalsIgnoreCase("y")){
				System.out.println("이름을 입력하세요");
				String name = sc.next();
				System.out.println("번호를 입력하세요");
				String tel = sc.next();
				System.out.println("주소를 입력하세요");
				sc.nextLine();
				String address = sc.nextLine();
				members.add(new Member(name, tel, address));
			}
		}
		if(members.isEmpty()) {
			System.out.println("리스트에 적힌 회원이 없습니다.");
		}
		for(Member m : members) {
			System.out.println(m);
		}sc.close();
	}
}
