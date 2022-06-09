package com.lec.ex1_runnable;
//안녕하세요 10번 반갑습니다 10번을 함께 실행하려는데 왔다갔다 하는것을 확인하기 위해 Thread.sleep(500)넣어 0.5초간의 간격을 줌
//안녕하세요10번하는 타겟 target
public class TargetEx01 implements Runnable {
	
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++ ) {
			System.out.println("안녕하세요 - " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {} //현재 작업을 0.5초 동안 대기상태로
		}
		
	}
}
