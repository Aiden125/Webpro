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
			System.out.println("회원리스트를 추가하시겠습니까? 시작은 아무 키, 중지는N/n");
			String answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			}
			System.out.println("이름을 입력하세요");
			String name = sc.next();
			System.out.println("번호를 입력하세요");
			String tel = sc.next();
			System.out.println("주소를 입력하세요(ex:서울시 노원구)");
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
				System.out.println("........이하  " + customer.size() + "명 가입");
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
			System.out.println("가입된 회원이 없습니다.");
		}
		sc.close();
	}
}
