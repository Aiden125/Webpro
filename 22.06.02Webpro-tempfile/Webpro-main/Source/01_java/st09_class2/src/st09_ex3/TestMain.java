package st09_ex3;

public class TestMain {
	public static void main(String[] args) {
		Child c1 = new Child("°©¼øÀÌ");
		Child c2 = new Child("¶¯Ä¥ÀÌ");
		Child c3 = new Child("¼ú¹ÚÀÌ");
		c3.takemoney(1000);
		c2.takemoney(400);
		c1.takemoney(300);
	}
}
