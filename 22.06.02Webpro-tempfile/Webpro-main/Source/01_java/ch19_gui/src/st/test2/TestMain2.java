package st.test2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


public class TestMain2 {
	public static void main(String[] args) {
		HashMap<String, Customer> customer = new HashMap<String, Customer>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("ȸ������Ʈ�� �߰��Ͻðڽ��ϱ�? ������ �ƹ� Ű, ������N/n");
			String answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			}
			System.out.println("�̸��� �Է��ϼ���");
			String name = sc.next();
			System.out.println("��ȣ�� �Է��ϼ���");
			String tel = sc.next();
			System.out.println("�ּҸ� �Է��ϼ���(ex:����� �����)");
			sc.nextLine();
			String address = sc.nextLine();
			customer.put(tel, new Customer(name, tel, address));
		}
		if(customer.isEmpty()) {
			System.out.println("���Ե� ȸ���� �����ϴ�.");
		}
		Iterator<String> iterator = customer.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(customer.get(key));
		}
		System.out.println("\t.......");
		sc.close();
	}
}
