package com.lec.ex01_store;
//���� ��ħ         : ��ġ�-000  �δ��-000  �����-000 ���뱹-000  �����-000��
//���ð��� ����1ȣ��: ��ġ�-5,000  �δ��-5,000  �����-6,000 ���뱹-���Ⱦ� �����-1,000��
//���а��� ����2ȣ��: ��ġ�-5,000  �δ��-5,000  �����-5,000 ���뱹-5,000  �����-����
//���ǰ��� ����3ȣ��: ��ġ�-6,000  �δ��-7,000  �����-7,000 ���뱹-6,000  �����-1,000��

// HeadQuarterStore hstore = new HeadQuarterStore("����"); ��ü ���� �Ұ�(�߻�Ŭ��������)
public abstract class HeadQuarterStore {
	private	String str; //"����"
	
	//������ ����(�Ű����� 1�� �ִ°�)
	public HeadQuarterStore(String str) {
		this.str = str;
	}
	
	//�޼ҵ� ������ ���� ���� �Ǿ� �ִ� �޼ҵ� : �߻� �޼ҵ�(��ӹ��� Ŭ�������� �������̵� �ؾ���)
	//Ŭ���� �� �߻� �޼ҵ尡 �ϳ� �̻��� �� : �߻�Ŭ����
	public abstract void kimchi();
	public abstract void bude();
	public abstract void bibib();
	public abstract void sunde();
	public abstract void gonggibab();
	
	// getter&setter ����
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
}
