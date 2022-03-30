package ex6;
//CheckingAccount a2 = new CheckingAccount("11-11", "ȫ�浿", 2000, "1111-2222-3333-4444")
public class CheckingAccount extends Account {
	private String cardNo;
	
	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
		System.out.println(ownerName+"�� ���� �����ÿ��� 10�� �̻� �ݾ��� �ʿ��մϴ�.");
	}
	
	public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
		System.out.println(ownerName+"�� "+balance+"������ ���� ���� �Ǿ����ϴ�.");
	}
	
	public void pay(String cardNo, int amount) {
		if(this.cardNo.equals(cardNo)) {
			if(getBalance() >= amount) {
				setBalance(getBalance()-amount);
				System.out.println(amount+"�� �����Ͽ� ���� �ݾ� : "+getBalance());
			}else {
				System.out.println("�ܾ��� �����մϴ�.");
			}
		}
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
