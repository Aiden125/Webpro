package ex6;
//�������(Account) Ŭ���� ����
//������(�Ӽ�) : ���¹�ȣ(accountNo:String), ������(ownerName:String), �ܾ�(balance:long)
//���(�޼ҵ�) : �����ϴ�(void deposit(int)), �����ϴ�(int withdraw(int)), �ܾ���ȸ(long getBalance())
//Account a = new Account("100-1", "ȫ�浿"); / Account("100-2", "�ű浿", 222000)
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
			System.out.println("�Ա� �� �ܾ� : "+balance);
		}else {
			System.out.println("0������ ū �ݾ׸� �Ա� �����մϴ�.");
		}
	}
	
	public void withdraw(int money) {
		if(balance > money) {
			balance -= money;
			System.out.println("���� �ݾ� : "+money+"  ��� �� �ܾ� : "+balance);
		}else {
			System.out.println("�ܾ��� �����մϴ�.");
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
