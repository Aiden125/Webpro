package com.lec.ex10_customer;
// name, tel, hiredate(�Ի���), department(�μ�)
// Satff s = new Staff("ȫ", "010", "2022-08-22", "������")
public class Staff extends Person {
	private String hiredate;
	private String department;
	
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
	}
	// sysout(s.infoString) - [�̸�]ȫ [��ȭ]010 [�Ի���]2022 [�μ�]������
	@Override
	public String infoString() {
		return super.infoString()+" [�Ի���]"+hiredate+" [�μ�]"+department;
	}
}
