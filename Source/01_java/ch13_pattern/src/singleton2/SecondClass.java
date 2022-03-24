package singleton2;

public class SecondClass {
	public SecondClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("SecondClass 积己磊 角青吝");
		System.out.println("Singleton i 蔼 : "+singletonObject.getI());
		System.out.println("SecondClass 积己磊 场");
	}
}
