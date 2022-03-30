package ex6;
//은행계좌(Account) 클래스 설계
//데이터(속성) : 계좌번호(accountNo:String), 예금주(ownerName:String), 잔액(balance:long)
//기능(메소드) : 예금하다(void deposit(int)), 인출하다(int withdraw(int)), 잔액조회(long getBalance())
//Account a = new Account("100-1", "홍길동"); / Account("100-2", "신길동", 222000)
public class Account {
	private String accountNo;
	private String ownerName;
	private long balance;
	
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}

	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public void deposit(int money) {
		if (money > 0) {
			balance += money;
			System.out.println("입금 후 잔액 : "+balance);
		}else {
			System.out.println("0원보다 큰 금액만 입금 가능합니다.");
		}
	}
	
	public void withdraw(int money) {
		if(balance > money) {
			balance -= money;
			System.out.println("인출 금액 : "+money+"  출금 후 잔액 : "+balance);
		}else {
			System.out.println("잔액이 부족합니다.");
		}
	}
	
	

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	
}
