package st09_ex1;

import java.util.Scanner;
/*
������ ���� �� ��� : ��11��1111���� �������
                       �����ð� : 12��
������ ���� �� ��� : ��11��1111���� �ȳ��� ������
	             * �����ð� : 12��
		     * �����ð� : 14��
		     * ������� : 4000��
 */
public class Parking {
	//������
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
	private final int HOURLYPARKINGRATE=2000; //����� ���� ���� ���ִ� �� final�Ἥ �������� ���
	public Parking() {}
	
	//������ �Լ�
	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		System.out.printf("\"%s\"�� �������\n�����ð� : %d��\n\n", no, inTime);
	}
	//�޼ҵ�
	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime-inTime)* HOURLYPARKINGRATE;
		System.out.printf("\"%s\"�� �ȳ��� ������\n�����ð� : %d��\n�����ð� : %d��\n������� : %d��\n\n",no, inTime, outTime, fee);
	}

	public void out() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(inTime+"�ÿ� �����̴µ� ��ÿ� �����ϰ� ��Ű���?");
		outTime = scanner.nextInt();
		out(outTime);
		scanner.close();
	}
}
