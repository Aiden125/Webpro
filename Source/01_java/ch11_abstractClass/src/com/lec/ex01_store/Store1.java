package com.lec.ex01_store;
// ���ð��� ����1ȣ��: ��ġ 4500 �δ� 5000 ��� 6000 ���� ����  ���� 1000��
public class Store1 extends HeadQuarterStore {//�߻� Ŭ���� ����� stroe1�� ���콺 ���ٴ�� ctrl+1�������� ����

	public Store1(String str) {
		super(str);
	}
	@Override
	public void bude() {
		System.out.println("�δ�� - 5,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹 �� �Ⱦ�");
	}
	@Override
	public void kimchi() {
		System.out.println("��ġ� - 4,500��");
	}
	@Override
	public void bibib() {
		System.out.println("����� - 6,000��");
	}
	@Override
	public void gonggibab() {
		System.out.println("����� - 1,000��");
	}
}
