package ex1;

public class ChildClass extends ParentClass{
	String cStr = "아들클래스";
	public ChildClass() {
		System.out.println("자식 클래스 객체 부분 생성");
	}
	public void getChildName() {
		System.out.println("자식 이름 : 둘리");
	}
}
