package st1_singleton;

public class FirstClass {
	public FirstClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("singleton 객체의 i값 : "+singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("singleton 객체의 i값 수정 후 : "+singletonObject.getI());
	}
}
