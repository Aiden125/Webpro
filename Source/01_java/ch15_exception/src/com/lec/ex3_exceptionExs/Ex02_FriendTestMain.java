package com.lec.ex3_exceptionExs;

import java.util.Date;

public class Ex02_FriendTestMain {
	public static void main(String[] args) {
		Friend kim = new Friend("±è»ñ°«", "010-1234-1233");
		kim.setEnterDate(new Date(122, 2, 11));
		System.out.println(kim);
		Friend kim2 = new Friend("±è»ñ°«»ñ°«");
		System.out.println(kim2);
	}
}
