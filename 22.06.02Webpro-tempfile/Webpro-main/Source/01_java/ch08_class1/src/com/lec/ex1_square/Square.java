//패키지명, 클래스명, 데이터, 생성자함수(오버로딩), 메소드, setter&getter
package com.lec.ex1_square;

public class Square {
	private int side;
	//생성자 함수가 아예 없을 때는 JVM이 디폴트 생성자를 생성해줌
	//(아무 것도 하지 않는 매개변수 없는 생성자)
	
	//매개변수 없는 생성자
	//생성자 함수 : return타입이 없고 class명과 같은 함수
	public Square() { 
		System.out.println("매개변수 없는 생성자 함수 호출됨");
	}
	
	//매개 변수 있는 생성자 함수 용도 : 데이터 초기화
	public Square(int side) { 
		this.side = side;
		System.out.println("매개 변수 있는 생성자 함수 호출. side 초기화");
	}
	
	//메소드
	public int area() {
		return side*side;
	}
	// setter & getter
	// setS까지만 치고 자동완성 하면됨
	public void setSide(int side) {
		this.side = side;
	}
	public int getSide() {
		return side;
	}
}
