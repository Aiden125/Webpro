package st1_singleton;

public class SecondClass {
	public SecondClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("SecondClass ������ ������");
		System.out.println("Singleton i �� : "+singletonObject.getI());
		System.out.println("SecondClass ������ ��");
	}
}
