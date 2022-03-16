package com.lec.ex2_human;

public class ManTest {
	public static void main(String[] args) {
		Man kim = new Man();
		Man kang = new Man(22, 165, 60.5);
		Man moon = new Man(22, 165, 60.5, "010-9999-2222");
		System.out.println(moon);
//		Man yi = new Man(22);
//		Man yu = new Man(165);
	}
}
