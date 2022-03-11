package com.lec.ex;

public class VarEx06 {
	public static void main(String[] args) {
		int i1 = 10; // 4byte
		long l = 220000000L; // 8byte
		double d1 = 10; // 묵시적인 형변환(작은 byte값을 큰byte에 넣기에 데이터 손실x)
		System.out.println("d1="+d1);
		double d2= 10.19;
		int i2 = (int)d2; // 명시적인 형변환(데이터 손실 발생 가능)
		System.out.println("in2="+i2);
	}
}
