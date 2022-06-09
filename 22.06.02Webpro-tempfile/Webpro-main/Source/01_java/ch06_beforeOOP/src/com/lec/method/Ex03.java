package com.lec.method;
// Arithmetic.sum(static) / evenOdd(static) vs abs(일반 메소드 (static)안쓰는)
public class Ex03 {
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10);
		System.out.println("1~10까지 합은"+tot);
		System.out.println(Arithmetic.evenOdd(tot));
		Arithmetic ar = new Arithmetic();
		System.out.println(ar.abs(-8));
	}
}
