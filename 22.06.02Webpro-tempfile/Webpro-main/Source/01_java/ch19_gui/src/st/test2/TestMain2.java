package st.test2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


public class TestMain2 {
	public static void main(String[] args) {
		HashMap<String, Customer> customer = new HashMap<String, Customer>();
		Scanner sc = new Scanner(System.in);

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
			customer.put(tel, new Customer(name, tel, address));
		}
		if(customer.isEmpty()) {
			System.out.println("가입된 회원이 없습니다.");
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
