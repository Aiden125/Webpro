package com.lec.ex;

public class VarEx06 {
	public static void main(String[] args) {
		int i1 = 10; // 4byte
		long l = 220000000L; // 8byte
		double d1 = 10; // �������� ����ȯ(���� byte���� ūbyte�� �ֱ⿡ ������ �ս�x)
		System.out.println("d1="+d1);
		double d2= 10.19;
		int i2 = (int)d2; // ������� ����ȯ(������ �ս� �߻� ����)
		System.out.println("in2="+i2);
	}
}
