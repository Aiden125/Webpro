package com.lec.ex2_thread;
//runnable ���̵� �ٷ� thread���� �۾��� �����ϴ°͵� ����
//Thread t1= new TreadEx01();
// runnalbe���� �ϱ⿡ ���� �⺻�����̸�, �Ʒ�ó�� �Ű����� �ִ°� ������� ���� �����������
// ���� �����Ұ�
// Thread t1= new TreadEx01("A");
// �Ʒ� ������ ���ʺ� ���� �� ����
// Thread t1 = new Thread(target1, "A");
public class TargetEx01 extends Thread{
	public TargetEx01() {}
	public TargetEx01(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(int i=0 ; i<10 ; i++ ) {
			System.out.println(Thread.currentThread().getName());
			System.out.println("�ȳ��ϼ��� - " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {} //���� �۾��� 0.5�� ���� �����·�
		}
	}
}
