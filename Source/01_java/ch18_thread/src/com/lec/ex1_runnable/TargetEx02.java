package com.lec.ex1_runnable;
// �ݰ����ϴ� 10�� �ϴ� target ����
public class TargetEx02 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "�� °, �ݰ����ϴ�");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}

	}

}