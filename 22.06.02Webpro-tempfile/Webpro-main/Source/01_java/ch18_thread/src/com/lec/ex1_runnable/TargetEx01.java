package com.lec.ex1_runnable;
//�ȳ��ϼ��� 10�� �ݰ����ϴ� 10���� �Բ� �����Ϸ��µ� �Դٰ��� �ϴ°��� Ȯ���ϱ� ���� Thread.sleep(500)�־� 0.5�ʰ��� ������ ��
//�ȳ��ϼ���10���ϴ� Ÿ�� target
public class TargetEx01 implements Runnable {
	
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++ ) {
			System.out.println("�ȳ��ϼ��� - " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {} //���� �۾��� 0.5�� ���� �����·�
		}
		
	}
}
