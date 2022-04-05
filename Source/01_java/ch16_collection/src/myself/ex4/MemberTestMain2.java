package myself.ex4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MemberTestMain2 {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		String answer;
		boolean ok = false;

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
				
				
				
				///////////////////////////////////////////////
				Iterator<Member> iterator = members.iterator();
				while(iterator.hasNext()) {
					Member key = iterator.next();
					if(key.equals(0)) {
						ok = true;
						break;
					}
				}
				if(ok) {
					System.out.println("같은 번호가 있어서 추가 불가");
				}
				
				
				
				
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
