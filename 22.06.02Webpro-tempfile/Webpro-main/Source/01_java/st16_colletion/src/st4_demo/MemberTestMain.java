package st4_demo;

import java.util.ArrayList;
import java.util.Scanner;
// �����͸� ArrayList�� �ְ� ���
public class MemberTestMain {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		String answer;
		
		while(true) {
			System.out.println("ȸ�������� �Ͻðڽ��ϱ�? Y/N");
			answer = sc.next();
			if(answer.equalsIgnoreCase("n")) {
				break;
			}else if(answer.equalsIgnoreCase("y")){
				System.out.println("�̸��� �Է��ϼ���");
				String name = sc.next();
				System.out.println("��ȣ�� �Է��ϼ���");
				String tel = sc.next();
				System.out.println("�ּҸ� �Է��ϼ���");
				sc.nextLine();
				String address = sc.nextLine();
				members.add(new Member(name, tel, address));
			}
		}
		if(members.isEmpty()) {
			System.out.println("����Ʈ�� ���� ȸ���� �����ϴ�.");
		}
		for(Member m : members) {
			System.out.println(m);
		}sc.close();
	}
}
