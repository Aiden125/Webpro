package com.lec.ex2_parking;

public class ParkingTestMain {
	public static void main(String[] args) {
		Parking p1 = new Parking("11라1111", 12);
		Parking p2 = new Parking("15라1666", 12);
		p1.out(); // 사용자에게 outTime 받기
		p2.out(16); // outTime 15로 받기
	}
}
