package com.lec.ex4_threadNObjectN;
//������Ʈ�� �ϳ��� ���� �����ؼ� ���� ����(���� �ϳ��� ī�� �ΰ� ����)
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
		System.out.println("traget1�� num:"+target1.getNum());
		System.out.println("traget1�� num:"+target2.getNum());
		System.out.println("���� �Լ� ��");
	}
}
