package com.lec.ex1_awt;

import java.awt.*;

public class Ex01MyFrame extends Frame {
	private Button btn;
	private Button btn1;

	public Ex01MyFrame(String title) {
		super(title);
		// 버튼 2개를 추가한 프레임 만들기
		btn = new Button("버튼");
		btn1 = new Button("그냥 버튼");
		add(btn, BorderLayout.NORTH);
		add(btn1, BorderLayout.CENTER);
//		pack(); --> 최소한의 사이즈로
		setSize(300, 200);
		setVisible(true);
		setLocation(100, 50);

		// 실행 후 3초 지나면 자동 창 닫고 실행종료
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		setVisible(false); // 화면에 안보이게
		dispose(); // 자원해제
		System.exit(0); // 강제 종료
	}
	public static void main(String[] args) {
		new Ex01MyFrame("first GUI");
	}
}
