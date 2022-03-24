package com.lec.ex14_account;
// CheckingAccount a2 = new CheckingAccount("11-11", "ȫ�浿", 2000, "1111-2222-3333-4444")
public class CheckingAccount extends Account {
	private String cardNo;

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
		System.out.printf("%s(%s)�� ���� ���� ��� �� �Աݾ��� �ʿ��մϴ�.\n", ownerName, accountNo);
		// balance = 0; ���� ���� �ʱ�ȭ �Ǿ�����
	}
	public CheckingAccount(String accountNo, String ownerName,long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
		System.out.printf("%s(%s)�� %d�� ���� �����Ǿ����ϴ�\n", ownerName, accountNo, balance);
		// balance = 0; ���� ���� �ʱ�ȭ �Ǿ�����
	}
	// a2.pay("1111-1111-2222-3333",1000);
	public void pay(String cardNo, int amount) {
		if(this.cardNo.equals(cardNo)) { //String�� ��� �񱳴� a.equals(b) �̷������� �ؾ�.
			if(getBalance() >= amount) { //�Լ��� �� ��ȣ. ���Ұ�������
				setBalance(getBalance() - amount); //balance -= amount;
				System.out.printf("%s(%s)�� %d�� �����Ͽ� �ܾ� %d�� ���ҽ��ϴ�\n", getOwnerName(), getAccountNo(), amount, getBalance());
			}else {
				System.out.printf("%s(%s)�� �ܾ�%d������ %d�� ���� �Ұ��մϴ�.\n", getOwnerName(), getAccountNo(), getBalance(), amount);
			}
		}else {
			System.out.println("�ùٸ� ī���ȣ�� �Է��ϼ���");
		}//if
	}//pay
	public String getCardNo() {
		return cardNo;
	}
	
}//class
