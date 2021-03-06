package test;
//다음과 같은 출력결과가 나오도록 이름(name)과 전화번호(tel) 데이터를 갖고,
//생성자 함수를 갖는 클래스를 구현하고 다음 설명과 결과를 출력하도록 자바프로그래밍을 구현하시오(40점).

//데이터 = 이름(name), 번호(tel)
//생성자 = 이름, 번호
public class Person {
	private String name;
	private String tel;
	
	public Person(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "이름 " + name +", " + "전화번호 " + tel;
	}
	
}
