package st09_ex3;

public class TestMain {
	public static void main(String[] args) {
		Child c1 = new Child("������");
		Child c2 = new Child("��ĥ��");
		Child c3 = new Child("������");
		c3.takemoney(1000);
		c2.takemoney(400);
		c1.takemoney(300);
	}
}
