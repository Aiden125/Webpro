package st09_ex4;
// ����ƽ �Լ��� ���� ����.
public class Product {
	private int serialNo; // ��ü ���� �ѹ�101, 102, 103
	public static int count = 100; // ���� ����
	public Product() {
		serialNo = ++count;
	}
	public void infoPrint() {
		System.out.println("serialNo = " + serialNo + "\t�������� count = "+count);
	}
}