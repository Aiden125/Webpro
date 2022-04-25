package st.test;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer;
		boolean ok = false;

		Friend[] friends = {
				new Friend("ȫ�浿", "����� ��걸", "010-9999-1234", "05-22"),
				new Friend("���浿", "��⵵ ���ν�", "010-7777-1234", "04-08"),
				new Friend("�ڱ浿", "����� ������", "010-6666-1234", "12-05") };

		while (true) {
			System.out.println("�˻��� �ּ� �� ���� 2�ڸ�(��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�)");
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
				System.out.println("�˻��Ͻ� �ּ��� ģ���� �����ϴ�."+"\n");				
			}
		}
		sc.close();
	}
}
