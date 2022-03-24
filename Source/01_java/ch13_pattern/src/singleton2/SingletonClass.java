package singleton2;

public class SingletonClass { //이 방법으로도 동일하게 singleton 쓸 수 있음
	private int i = 10;
	
	private static SingletonClass INSTANCE = new SingletonClass();
	public static SingletonClass getInstance() {
		return INSTANCE;
	}
	private SingletonClass() {
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
