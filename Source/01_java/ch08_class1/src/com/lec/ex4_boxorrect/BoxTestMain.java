package com.lec.ex4_boxorrect;

public class BoxTestMain {
	public static void main(String[] args) {
		BoxOrRect box = new BoxOrRect(5,6,10);
		BoxOrRect rect = new BoxOrRect(10,5);
		box.vPrint();
		rect.vPrint();
		System.out.println("�ڽ� ���Ǵ�"+box.getVolume());
		System.out.println("rect ���̴�"+box.getVolume());
	}
}
