package st1_singleton;

public class FirstClass {
	public FirstClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("singleton ��ü�� i�� : "+singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("singleton ��ü�� i�� ���� �� : "+singletonObject.getI());
	}
}
