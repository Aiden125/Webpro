package com.lec.ex7_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true); // 기본적으로 false값이기 때문에 true로 바꾸지 않으면 프로그램이 끝나도 계속 timer가 상주
		TimerTask task1 = new TimerTaskEx1();
		TimerTask task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000); //2초후에(밀리세컨) task1수행
		timer.schedule(task2, 1000, 500); //2초후에(밀리세컨) task1수행
		//5초 동안 잠깐 멈춤
		Thread.sleep(5000); //3초 동안 멈추고 실행할 여유를 만들어줌. 다만 멈추고 다시 구동을 할지 안할지 몰라서 오류 띄어줌.
		System.out.println("끝");
	}
}
