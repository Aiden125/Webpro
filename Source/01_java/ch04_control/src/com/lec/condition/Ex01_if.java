package com.lec.condition;

public class Ex01_if {

	public static void main(String[] args) {
		int seoulLunchPrice = 4000;
		if(seoulLunchPrice >= 8000) {
			System.out.println("���� ���� �� ��γ׿�");
		} else if(seoulLunchPrice >= 6000) {
			System.out.println("������ �ʳ�");
		} else if(seoulLunchPrice >= 5000) {
			System.out.println("������");
		} else {
			System.out.println("�Ĵ� ���� ���ϴ°� �ƴϾ�?");
		}
	}
}
