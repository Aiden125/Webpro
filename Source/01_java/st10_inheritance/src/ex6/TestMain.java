package ex6;
//a1고객님 계좌번호만 가지고 계좌개설 입금 두번 출금 두번
//a2고객님 계좌번호, 이름, 예금액, 카드번호로 카드 개설. 입금, 출금 한 번씩,
//a3고객님 계좌번호, 이름, 예금액, 카드번호, 한도로 신용카드 개설
public class TestMain {
	public static void main(String[] args) {
		Account a1 = new Account("111-1234", "홍길동");
		a1.deposit(3000);
		a1.deposit(6000);
		a1.withdraw(5000);
		a1.withdraw(10000);
		System.out.println("---------------------------");
		CheckingAccount a2 = new CheckingAccount("123-1234", "이지훈", "1234-1234-5678");
		a2.deposit(10000);
		a2.withdraw(20000);
		a2.pay("1234-1234-5678", 5000);
		a2.pay("1234-1234-5678", 10000);
		System.out.println("---------------------------");
		CreditLineAccount a3 = new CreditLineAccount("121-1212", "문희석", "7777-7777-7777", 100000000);
		a3.deposit(50000000);
		a3.pay("7777-7777-7777", 50000000);
		a3.pay("7777-7777-7777", 50000);
	}
	
}
