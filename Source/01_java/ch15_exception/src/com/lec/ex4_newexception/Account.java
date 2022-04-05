package com.lec.ex4_newexception;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	} // ���� : ������ �������� ��� -> ���� -> ���� �� �������� ���
	public void deposit(int amount) { // Account a =new Account("1-1", "ȫ", 100)
									  // Sysout("������ : " + a)
									  // a.deposit(100) -> deposit�Լ� �������� this�� a
		System.out.println("������ : " + this);
		balance += amount;
		System.out.println(amount + "�� ���� �� : " + this);
	}//��� : �ܾ�Ȯ�� -> ��� �� �������� ��� -> ��� -> ��� �� �������� ���
	public void withdraw(int amount) throws Exception {
		if(balance<amount) { //�ܾ׺������� ��ݵ��� ���� : ��������
			throw new Exception(amount + "�� ����ϱ⿡�� �ܾ��� �����մϴ�. �����ܾ�"+balance); //�� �޼ҵ带 �����Ŷ�� ���ο� �������
		}
		System.out.println("����� : " + this);
		balance -= amount; // balance = balance - amount;
		System.out.println(amount + "�� ��� �� : " + this);
	}
	@Override
	public String toString() {
		return "���¹�ȣ:"+accountNo+"\t������:"+ownerName+"\t�ܾ�"+balance;
	}
	
	
}