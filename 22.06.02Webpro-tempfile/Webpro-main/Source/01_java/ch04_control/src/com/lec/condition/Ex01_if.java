package com.lec.condition;

public class Ex01_if {

	public static void main(String[] args) {
		int seoulLunchPrice = 4000;
		if(seoulLunchPrice >= 8000) {
			System.out.println("서울 점심 값 비싸네요");
		} else if(seoulLunchPrice >= 6000) {
			System.out.println("나쁘지 않네");
		} else if(seoulLunchPrice >= 5000) {
			System.out.println("괜찮네");
		} else {
			System.out.println("식당 주인 망하는거 아니야?");
		}
	}
}
