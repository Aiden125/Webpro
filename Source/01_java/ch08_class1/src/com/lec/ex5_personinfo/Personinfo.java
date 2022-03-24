package com.lec.ex5_personinfo;
/*
name, age, gender를 데이터로 갖고, 데이터 정보를 출력하는 print()
메소더를 갖는 PersonInfo 클래스를 구현하고 main함수를 이용하여 test 구현하시오
(print() 메소드 실행 결과 : 이름=홍길동, 나이=20, 성별=m, main 메소드 안에는
PersonInfo형 객체 인스턴스를 배열로 구현해 봅니다)
*/
public class Personinfo {
	//데이터 부문
	private String name;
	private int age;
	private char gender;
	//데이터 부문(여기까지)
	
	//디폴트 생성자
	//마우스 우클릭 후 소스 제너레이트 form superclass
	public Personinfo() {}
	
	//내가 원하는 생성자
	//마우스 우클릭 및 from Using Field 선택
	public Personinfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		
	}
	
	//메소드
	public void print() {
	System.out.println("이름="+name+"  나이="+age+"  성별="+gender);
	}
}
