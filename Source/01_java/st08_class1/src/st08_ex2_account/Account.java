package st08_ex2_account;
/*
�������(Account) Ŭ���� ����
������(�Ӽ�) : ���¹�ȣ(accountNo:String), ������(ownerName:String), �ܾ�(balance:long)
���(�޼ҵ�) : �����ϴ�(void deposit(int)), �����ϴ�(int withdraw(int)), �ܾ���ȸ(long getBalance())
Account a = new Account("100-1", "ȫ�浿"); / Account("100-2", "�ű浿", 222000)
*/
public class Account {
	private String accountNo;
	private String ownerName;
	private long balance;

	// ������ �Լ�(������ �����) 3���� ����� -> ������(�ν��Ͻ�, �Ķ����) �ʱ�ȭ�� only goal
	// return Ÿ���� ������ϰ� public�̾���ϰ�, class�̸��� ���ƾ���
	public Account() { // ����Ʈ ������
	} 

	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		// balance = 0; �̰� ���ص� ��(�⺻������ ��ü ������ 0������ �ʱ�ȭ)
		System.out.printf("%s(%s)�� ���� ���� ��� �� �Աݾ��� �ʿ��մϴ�.\n", ownerName, accountNo);
	}

	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		// balance = 0; �̰� ���ص� ��(�⺻������ ��ü ������ 0������ �ʱ�ȭ)
		System.out.printf("%s(%s)�� %d�� ���� �����Ǿ����ϴ�\n", ownerName, accountNo, balance);
	}

	// �޼ҵ� �ۼ�
	public void deposit(int money) { //������ ��� money�� ������ ����ó��
		if(money>0) {
			balance += money;
			System.out.println(ownerName+"�� "+money+"���� ���¿� �ԱݵǼ̽��ϴ�.");
		}else {
			System.out.println("0���� ū �ݾ׸� �����մϴ�.\n");
		}
	}

	public void withdraw(int money) {
		if (money <= balance) {
			balance -= money;
			System.out.println(ownerName+"�� "+money+"���� ��� �Ǿ����ϴ�.");
		} else {
			System.out.println(ownerName+"�� "+(money-balance)+"�� ��ŭ �ܾ��� �����մϴ�.");
		}
	}

	public String infoPrint() {// ȫ�浿(100-1)�� �ܾ� : 1000��
		// string.format�� ���� printf�� ���� ȿ��
		return String.format("%s(%s)�� �ܾ� : %d��\n", ownerName, accountNo, balance);
	}
	
	//setter & getter (�ڵ��ϼ� setAcc ģ ���� ctrl+space Ȱ�� ���� �Ȱ��� ������� get�� ����)
	//��Ŭ�� source �� generate Ŭ�� �� setter & getter ������ �߰� Ȥ�� ��� �޴� Ȱ��
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

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}
