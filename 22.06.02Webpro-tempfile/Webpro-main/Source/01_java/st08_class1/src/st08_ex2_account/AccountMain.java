package st08_ex2_account;

public class AccountMain {
	public static void main(String[] args) {
		Account hong = new Account("100-1","홍길동",200);
		Account shin = new Account("101-1","신길동");
		Account acc = new Account();
		System.out.println();
		acc.setAccountNo("101-2");
		acc.setOwnerName("유길동");
		System.out.print(hong.infoPrint());
		System.out.print(shin.infoPrint());
		System.out.print(acc.infoPrint());
		System.out.println();
		shin.deposit(20000);
		shin.withdraw(30000);
		hong.withdraw(30000000);
		acc.withdraw(10);
		System.out.println();
		System.out.print(hong.infoPrint());
		System.out.print(shin.infoPrint());
		System.out.print(acc.infoPrint());
	}
}