package st1_api;

import java.util.Scanner;

public class FriendTestMain {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("ȫ�浿", "010-9999-9999", "05-22"),
				new Friend("�ű浿", "010-8888-8888", "09-22"),
				new Friend("���浿", "010-8888-9999", "08-22"),
				new Friend("���浿", "010-7777-7777", "04-22"),
				new Friend("��浿", "010-6666-7777", "03-22") };
		
		// boolean�� ���� ���� ����
		// ����ڿ��� ���� ���� ���� ����
		Scanner sc = new Scanner(System.in);
		while (true) {
			String su;
			System.out.println("��ȭ��ȣ �� �ڸ��� �Է��Ͻÿ�");
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
				System.out.println("�˻��Ͻ� ģ���� ��ȸ���� �ʽ��ϴ�");
			}
		}sc.close();
	}
}
