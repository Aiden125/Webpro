package com.lec.ex5_lib;

public interface ILendable {
	//data
	public byte STATE_BORROWED=1; //�������� ���� static final ���� 
	public byte STATE_NORMAL=0; //���� ������ ���� static final ����
	
	//method
	public void checkOut(String borrower) throws Exception; //����. ����ó���� ���ϸ� ���� ���ʰ� �Ǵ� ���� ���ٰ�
	public void checkIn() throws Exception; //�ݳ�. ���������� ����ó���� ���ؼ� ����ٰ� ����
}
