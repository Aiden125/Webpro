package com.lec.ex07_friend;

public class TestMain {
	public static void main(String[] args) {
		Friend f1 = new Friend();
		System.out.println(f1.infoString());
		Friend f2 = new Friend("È«±æ");
		System.out.println(f2.infoString());
		Friend f3 = new Friend("È«±æ", "010-9929-3311");
		System.out.println(f3.infoString());
	}
}
