package com.lec.ex3_threadNObject1;
//오브젝트가 하나면 서로 공유해서 쓰는 느낌(통장 하나로 카드 두개 쓰는)
public class TargetExTestMain {
	public static void main(String[] args) {
		TargetEx target = new TargetEx();
		Thread threadA = new Thread(target, "A");
		Thread threadB = new Thread(target, "B");
		threadA.start();
		threadB.start();
		System.out.println("메인 함수 끝");
	}
}
