package com.lec.ex4_threadNObjectN;
//바로 매개변수 있는 객체 실행을 위해서 정의해줌
//ThreadEx threadA = new ThreadEx("A")
//수행중엔 껴들지 않게 싱크로나이즈. 별도 out이라는 메소드 정의 현재는 오브젝트가 여러개라 안먹힘
public class ThreadEx extends Thread{
	private int num = 0;
	public ThreadEx(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++) {
			out(); 
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}
	}
	private synchronized void out() { //이 함수를 쓸 때는 못껴들게 하는게 void앞에 싱크로나이즈드
		if(Thread.currentThread().getName().equals("A")) { //"A"쓰레드일 경우
			System.out.println("~ ~ ~ A쓰레드 수행중 ~ ~ ~");
			num++;
		}
		System.out.println(Thread.currentThread().getName()+"의 num = " + num);
		
	}
	public int getNum() {
		return num;
	}
}
