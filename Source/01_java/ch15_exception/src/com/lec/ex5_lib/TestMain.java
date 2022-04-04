package com.lec.ex5_lib;

import java.util.Date;

public class TestMain {
	public static void main(String[] args) {
		BookLib book1 = new BookLib("91a-01", "java", "이고잉");
		BookLib book2 = new BookLib("55d-01", "python", "박이선");
		System.out.println(book1);
		try {
			book1.checkOut("김빌림");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 대출일 조작
		book1.setCheckOutDate(new Date(122, 2, 11)); // 2022년 3월 11일에 빌린것으로 설정
		System.out.println(book1);
		try {
			book1.checkIn();
		} catch (Exception e) {
			System.out.println("예외 메시지" + e.getMessage());
		}
		System.out.println(book1);
	}
}
