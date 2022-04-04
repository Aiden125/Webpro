package com.lec.ex5_lib;

import java.util.Date;

public class TestMain {
	public static void main(String[] args) {
		BookLib book1 = new BookLib("91a-01", "java", "�̰���");
		BookLib book2 = new BookLib("55d-01", "python", "���̼�");
		System.out.println(book1);
		try {
			book1.checkOut("�����");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// ������ ����
		book1.setCheckOutDate(new Date(122, 2, 11)); // 2022�� 3�� 11�Ͽ� ���������� ����
		System.out.println(book1);
		try {
			book1.checkIn();
		} catch (Exception e) {
			System.out.println("���� �޽���" + e.getMessage());
		}
		System.out.println(book1);
	}
}
