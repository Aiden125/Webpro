package com.lec.ex14_account;
// a1고객 홍길동님 계좌번호만 가지고 계좌개설 입금 두번 출금 두번
// a2고객님 계좌번호, 이름, 예금액, 카드번호로 카드 개설. 입금, 출금 한 번씩,
// a3고객님 계좌번호, 이름, 예금액, 카드번호, 한도로 신용카드 개설
public class TestMain {
	public static void main(String[] args) {
		Account a1 = new Account("111-223222", "홍길동");
		a1.deposit(3000);
		a1.deposit(9000);
		a1.withdraw(1000);
		a1.withdraw(12000);
		System.out.println("-------------------------------");
		CheckingAccount a2 = new CheckingAccount("222-3333", "박석길", 1000, "1111-2222-3333-4444");
		a2.deposit(10000);
		a2.withdraw(30000);
		a2.pay("111-222-333-4", 20000);
		a2.pay("1111-2222-3333-4444", 10000);
		System.out.println("-------------------------------");
		CreditLineAccount a3 = new CreditLineAccount("333-332", "홍길준", 10000, "1111-1111", 100000);
		a3.deposit(10000);
		a3.pay("1111-1111", 15000);
		a3.pay("1111-1111", 100000);
	}
}
