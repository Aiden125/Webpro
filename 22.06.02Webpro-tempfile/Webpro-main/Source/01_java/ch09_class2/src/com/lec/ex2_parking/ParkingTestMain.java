package com.lec.ex2_parking;

public class ParkingTestMain {
	public static void main(String[] args) {
		Parking p1 = new Parking("11��1111", 12);
		Parking p2 = new Parking("15��1666", 12);
		p1.out(); // ����ڿ��� outTime �ޱ�
		p2.out(16); // outTime 15�� �ޱ�
	}
}
