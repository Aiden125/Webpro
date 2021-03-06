package com.lec.ex4_threadNObjectN;
//오브젝트가 하나면 서로 공유해서 쓰는 느낌(통장 하나로 카드 두개 쓰는)
public class TargetExTestMain {
	public static void main(String[] args) {
		TargetEx target1 = new TargetEx();
		TargetEx target2 = new TargetEx();
		Thread threadA = new Thread(target1, "A");
		Thread threadB = new Thread(target2, "B");
		threadA.start();
		threadB.start();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) { }
		System.out.println("traget1의 num:"+target1.getNum());
		System.out.println("traget1의 num:"+target2.getNum());
		System.out.println("메인 함수 끝");
	}
}
