package com.lec.ex02_store;
//���а��� ����2ȣ��: ��ġ 5 �δ� 5 ��� 5 ���� 5 ����-����
public class Store2 extends HeadQuarterStore {
	
	private String str;
	public Store2(String str) {
		this.str = str;
	}
	@Override
	public void bude() {
		System.out.println("�δ�� - 5,000��");
	}
	@Override
	public void bibib() {
		System.out.println("����� - 5,000��");
	}
	@Override
	public void gonggibab() {
		System.out.println("����� ����");
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ� - 5,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹 - 5,000��");
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
}
