package com.lec.ex1_runnable;
//�ȳ��ϼ���, �ݰ����ϴ� �������� ������
public class TargetExTestMain {
	public static void main(String[] args) {
		Runnable target1 = new TargetEx01();
		Runnable target2 = new TargetEx02();
		//�ٷ� TragetEx02 target2 = new TargetEx02();
		//"A"��� �̸��� ������ ���� - target1.run() ����
		Thread threadA = new Thread(target1, "A");
		//"B"��� �̸��� ������ ���� - target2.run() ����
		Thread threadB = new Thread(target2, "B");
		//�۾� ��ŸƮ�ϴ� �޼ҵ�
		threadA.start();
		threadB.start();
		for(int i=0 ; i<10 ; i++) {
			System.out.println("���� " + Thread.currentThread().getName() + i ); //���� ������ �̸� �ҷ�����Thread.currentTread().getName()
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
}
