package com.lec.ex4_newexception;

public class AccountTestMain {
	public static void main(String[] args) {
		Account obj1 = new Account("111-112", "���");
		Account obj2 = new Account("222-112", "�辦��", 2000);
		obj1.deposit(1000);
		obj2.deposit(1000);
		try {
			obj1.withdraw(500);
		} catch (Exception e) {
			System.out.println("���ܸ޽��� : "+e.getMessage());
		} // withdraw �޼ҵ� ����� throws�� ������ ȣ��ÿ��� try-catch
		try {
			obj2.withdraw(30000);
		} catch (Exception e) {
			System.out.println("���ܸ޽��� : "+e.getMessage());
		}
	}
}
