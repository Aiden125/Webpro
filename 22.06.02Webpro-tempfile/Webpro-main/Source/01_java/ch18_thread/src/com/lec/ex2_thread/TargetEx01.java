package com.lec.ex2_thread;
//runnable 없이도 바로 thread에서 작업을 수행하는것도 가능
//Thread t1= new TreadEx01();
// runnalbe없이 하기에 위가 기본형태이며, 아래처럼 매개변수 있는걸 만드려면 따로 정의해줘야함
// 본문 참조할것
// Thread t1= new TreadEx01("A");
// 아래 형식은 러너블 있을 때 가능
// Thread t1 = new Thread(target1, "A");
public class TargetEx01 extends Thread{
	public TargetEx01() {}
	public TargetEx01(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++ ) {
			System.out.println(Thread.currentThread().getName());
			System.out.println("안녕하세요 - " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {} //현재 작업을 0.5초 동안 대기상태로
		}
	}
}
