package com.lec.ex1_string;
// String ����(10����) >>>> StringBuffer ����(10����) > StringBuilder ����(10����)(�ӵ��� ������)
public class Ex11_speedCheck {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis()); //1970�� 1��1�Ϻ��� ���ݱ����� �и�����
		// ��Ʈ�� ����(10����) - �ð�üũ
		String str = "A";
		long startTime = System.currentTimeMillis(); // ���� ���۽����� �и����� 1970.1.������.
		for(int i=0 ; i < 100000 ; i++) { // 10���� ����
			str += "a";
		}
		long endTime = System.currentTimeMillis(); //���� ������ ������ �и�����
		System.out.println("String 10���� ���� ��� �ð� : "+(endTime-startTime));
		
		
		// StringBuffer ����(10����) - �ð�üũ
		StringBuffer strBuf = new StringBuffer("A");
		startTime = System.currentTimeMillis();
		for(int i=0 ; i < 100000 ; i++) { // 10���� ����
			strBuf.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer 10���� ���� ��� �ð� : "+(endTime-startTime));
		
		//SrginBuilder ����(10����) - �ð�üũ
		startTime = System.currentTimeMillis();
		StringBuilder strBuld = new StringBuilder("A");
		for(int i=0 ; i < 100000 ; i++) { // 10���� ����
			strBuld.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder 10���� ���� ��� �ð� : "+(endTime-startTime));
	}
}
