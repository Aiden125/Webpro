package com.lec.ex2_throws;

public class ThrowsEx {
	public ThrowsEx() throws Exception {
		actionC();			
	}
	//�� ������ ���� ȣ���� ������ �ٽ� �ǵ��ư�
	//���� ��ü���� ��� ���ο�� �����ٸ� ����ڰ� ������ ���ԵǱ� ������
	//�ּ��� ���� ��ü������ try-catch�� ���ܸ� ��������
	//API�� ���ο�� �Ǿ��ִ°� ���� ������ �̷� ������ API�� �� ����
	//���� ����ó���� �ؾ� �ȴٴ°� �����ϰ� �־����
	private void actionC() throws Exception{
		System.out.println("actionC ���ݺ�");
		actionB();
		System.out.println("actionC �Ĺݺ�");
	}
	private void actionB() throws RuntimeException{
		System.out.println("actionB ���ݺ�");
		actionA();			
		System.out.println("actionB �Ĺݺ�");
	}
	//throws ArrayIndex~~
	//actionA���� ������ ���� �� �ִٰ� ���� ȣ���� ������ ������ ��
	//�װ� ���� ������ ó���ϰų� �ű⼭�� �ѱ�ų�
	//��, �����ԵǸ� �� ���ܺ��� �ٷ� ���� ������ �ѱ�ԵǱ⿡ �� �̻� ����x
	private void actionA() throws ArrayIndexOutOfBoundsException{
		System.out.println("actionA ���ݺ�");
		int[] arr = {0,1,2,3};
		System.out.println(arr[4]); // ��������
		System.out.println("actionA �Ĺݺ�");
	}
}
