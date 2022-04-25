package com.lec.ex4_threadNObjectN;
//�ٷ� �Ű����� �ִ� ��ü ������ ���ؼ� ��������
//ThreadEx threadA = new ThreadEx("A")
//�����߿� ������ �ʰ� ��ũ�γ�����. ���� out�̶�� �޼ҵ� ���� ����� ������Ʈ�� �������� �ȸ���
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
	private synchronized void out() { //�� �Լ��� �� ���� ������� �ϴ°� void�տ� ��ũ�γ������
		if(Thread.currentThread().getName().equals("A")) { //"A"�������� ���
			System.out.println("~ ~ ~ A������ ������ ~ ~ ~");
			num++;
		}
		System.out.println(Thread.currentThread().getName()+"�� num = " + num);
		
	}
	public int getNum() {
		return num;
	}
}
