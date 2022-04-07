package st.test2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class TestMain1 {
	public static void main(String[] args) {
		ArrayList<Customer> customer = new ArrayList<Customer>();
		Scanner sc = new Scanner(System.in);
		OutputStream os = null;

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
			customer.add(new Customer(name, tel, address));
		}
		try {
			os = new FileOutputStream("src/st/test2/cus.txt", true);
			for (Customer c : customer) {
				System.out.println(c);
				os.write(c.toString().getBytes());
			}
			if (!customer.isEmpty()) {
				System.out.println("........����  " + customer.size() + "�� ����");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (Exception e2) {
			}
		}
		if (customer.isEmpty()) {
			System.out.println("���Ե� ȸ���� �����ϴ�.");
		}
		sc.close();
	}
}
