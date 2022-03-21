package com.lec.ex10_customer;
// name, tel, address, sum, point, date, vip
// Customer c = new Customer("ȫ", "010-22-33", "���� ����� ���","1992-12-12");
public class Customer extends Person {
	private String address;
	private int sum; // ���� ���� �ݾ�
	private int point; // ����Ʈ(���Ÿ��� 5%����)
	private String date; // �����(���� date ���x)
	private boolean vip; // true�� vip, false�� �Ϲ�
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);
		this.address = address;
		this.date = date;
		point = 1000; // �� �����Դ� 1000p �ڵ� ����
		System.out.println(name+"�� �����մϴ�. ���� ������� ����Ʈ 1000���� ������ �帳�ϴ�.");
	}
	public void buy(int price) {// c.buy(10000)
		sum += price;
		int tempPoint = (int)(price*0.05);
		point += tempPoint;
		System.out.println(getName()+"�� �����մϴ�. �̹� ����Ʈ : "+tempPoint+"�� �߰��Ǿ� ���� ����Ʈ : "+point);
		if(sum>=1000000 && vip==false) {
			vip = true; // ���� ���� �ݾ��� 100���� �̻� �� vip������ ����
			System.out.println(getName() + "�� VIP������ ���׷��̵� �Ǽ̽��ϴ�.");
		}// if
	}// buy
	// 1�� c.print() or 2�� sysout(c.infoString()) or 3�� sysout(c)
	// sysout(c.infoString()) / super.infoString() "[�̸�]ȫ[��ȭ]010-2222-22"
	@Override // @ : ������̼�. ������ �ùٸ��� üũ����
	public String infoString() {
		return super.infoString() +" [�ּ�]"+address+" [����Ʈ]"+point+" [�����ݾ�]"+sum;
	}
}
