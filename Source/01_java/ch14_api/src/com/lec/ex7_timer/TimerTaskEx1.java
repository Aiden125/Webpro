package com.lec.ex7_timer;
import java.util.TimerTask;
//timer(타이머)의 종류는 두 가지
//1. 몇 분 후에 뭐 해라(1회 명령)
//2. 몇 분 후부터 몇분, 몇 시간마다 뭘 해라(반복명령)
public class TimerTaskEx1 extends TimerTask {
	@Override
	public void run() {
		System.out.println("작업1 : 2초후에 한번 수행될 예정인 작업(TimerTask)@@@");
		
	}

}
