package com.lec.ex7_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTestMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("����");
		Timer timer = new Timer(true); // �⺻������ false���̱� ������ true�� �ٲ��� ������ ���α׷��� ������ ��� timer�� ����
		TimerTask task1 = new TimerTaskEx1();
		TimerTask task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000); //2���Ŀ�(�и�����) task1����
		timer.schedule(task2, 1000, 500); //2���Ŀ�(�и�����) task1����
		//5�� ���� ��� ����
		Thread.sleep(5000); //3�� ���� ���߰� ������ ������ �������. �ٸ� ���߰� �ٽ� ������ ���� ������ ���� ���� �����.
		System.out.println("��");
	}
}
