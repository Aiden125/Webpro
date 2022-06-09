package com.lec.ex3_threadNObject1;
//수행중엔 껴들지 않게 싱크로나이즈. 별도 out이라는 메소드 정의
public class TargetEx implements Runnable{
	private int num = 0;
	
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			out();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}
	}
	private synchronized void out() {
		if(Thread.currentThread().getName().equals("A")) { //"A"쓰레드일 경우
			System.out.println("~ ~ ~ A쓰레드 수행중 ~ ~ ~");
			num++;
		}
		System.out.println(Thread.currentThread().getName()+"의 num = " + num);
	}
}
