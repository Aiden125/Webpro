package singleton1;

public class SingletonClass {//싱글턴이다하면 데이터, 게터세터, 생성자(프라이빗) 만드는거 바로 생각하기, 클래스명 타입의 스태틱 instance만들기, if 및 리턴값
	private int i;
	
	//객체생성 했으면 그 객체 주소를 return하고
	//객체생성 안 했으면 객체 생성하고 그 주소를 return.
	private static SingletonClass INSTANCE; //기본적으로 null값이 초기화
	public static SingletonClass getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;	
		}
	private SingletonClass() {}//singleton에서는 private로 매개변수 없는 생성자 생성

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
}
