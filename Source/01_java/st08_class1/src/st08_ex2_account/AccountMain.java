package st08_ex2_account;

public class AccountMain {
	public static void main(String[] args) {
		Account hong = new Account("100-1","ȫ�浿",200);
		Account shin = new Account("101-1","�ű浿");
		Account acc = new Account();
		System.out.println();
		acc.setAccountNo("101-2");
		acc.setOwnerName("���浿");
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