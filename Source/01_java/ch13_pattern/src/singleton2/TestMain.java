package singleton2;

public class TestMain {
	public static void main(String[] args) {
		FirstClass firstObj = new FirstClass();
		System.out.println("");
		SecondClass secondobj = new SecondClass();
		System.out.println("");
		SingletonClass singObj = SingletonClass.getInstance();
		System.out.println("Main�Լ����� �̱��� ��ü�� �� : "+singObj.getI());
	}
}
