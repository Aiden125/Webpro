package myself.ex4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MemberTestMain3 {
	public static void main(String[] args) {
		HashMap<String, Member> map = new HashMap<String, Member>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("�̸��� �Է��ϼ��� (������ N/n)");
			String name = sc.next();
			if(name.equalsIgnoreCase("n")) {
				break;
			}
			System.out.println("��ȣ�� �Է��ϼ���");
			String tel = sc.next();
			System.out.println("�ּҸ� �Է��ϼ���");
			sc.nextLine();
			String address = sc.nextLine();
			map.put(tel, new Member(name, tel, address));
		}
		if(map.isEmpty()) {
			System.out.println("���Ե� ȸ���� �����ϴ�.");
		}
		Iterator<String> iterator = map.keySet().iterator();
		if(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(map.get(key));
		}
		sc.close();
	}
}
