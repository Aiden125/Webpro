package com.lec.ex4_newexception;

public class AccountTestMain {
	public static void main(String[] args) {
		Account obj1 = new Account("111-112", "김삿갓");
		Account obj2 = new Account("222-112", "김쑥갓", 2000);
		obj1.deposit(1000);
		obj2.deposit(1000);
		try {
			obj1.withdraw(500);
		} catch (Exception e) {
			System.out.println("예외메시지 : "+e.getMessage());
		} // withdraw 메소드 선언시 throws가 있으면 호출시에도 try-catch
		try {
			obj2.withdraw(30000);
		} catch (Exception e) {
			System.out.println("예외메시지 : "+e.getMessage());
		}
	}
}
