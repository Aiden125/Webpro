package com.lec.ex14_account;

public class TestMain {
	public static void main(String[] args) {
		Account a1 = new Account("111-223222", "È«±æµ¿");
		a1.deposit(3000);
		a1.deposit(9000);
		a1.withdraw(1000);
		a1.withdraw(12000);
		System.out.println("-------------------------------");
		CheckingAccount a2 = new CheckingAccount("222-3333", "¹Ú¼®±æ", 1000, "1111-2222-3333-4444");
		a2.deposit(10000);
		a2.withdraw(30000);
		a2.pay("111-222-333-4", 20000);
		a2.pay("1111-2222-3333-4444", 10000);
		System.out.println("-------------------------------");
		CreditLineAccount a3 = new CreditLineAccount("333-332", "È«±æÁØ", 10000, "1111-1111", 100000);
		a3.deposit(10000);
		a3.pay("1111-1111", 15000);
		a3.pay("1111-1111", 100000);
	}
}
