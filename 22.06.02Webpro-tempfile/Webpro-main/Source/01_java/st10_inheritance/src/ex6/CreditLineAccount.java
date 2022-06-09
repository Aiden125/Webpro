package ex6;
//CreditLineAccount c2 = new CreditLineAccount("11-11", "ȫ", "1111-2222-3333-4444", 10000)
//CreditLineAccount c2 = new CreditLineAccount("11-11", "ȫ", 1000, "1111-2222-3333-4444", 10000)
public class CreditLineAccount extends CheckingAccount {
	private int creditLine;
	
	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;	
	}
	
	public CreditLineAccount(String accountNo, String ownerName, long balance, String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;	
	}
	
	@Override
	public void pay(String cardNo, int amount) {
		if(getCardNo().equals(cardNo)) {
			if(creditLine >= amount) {
				creditLine -= amount;
				System.out.println(getOwnerName()+"�� �ѵ� "+creditLine+"�� ���ҽ��ϴ�.");
			}else {
				System.out.println("�ѵ��� �ʰ��Ǿ����ϴ�.");
			}
		}else {
			System.out.println("�ùٸ� ī���ȣ�� �Է��ϼ���.");
		}
	}

}
