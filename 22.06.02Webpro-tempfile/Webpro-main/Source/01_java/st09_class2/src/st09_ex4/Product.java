package st09_ex4;
// 스태틱 함수에 대한 이해.
public class Product {
	private int serialNo; // 객체 고유 넘버101, 102, 103
	public static int count = 100; // 공유 변수
	public Product() {
		serialNo = ++count;
	}
	public void infoPrint() {
		System.out.println("serialNo = " + serialNo + "\t공유변수 count = "+count);
	}
}
