package com.lec.ex4_boxorrect;
/*
직육면체의 가로, 세로, 높이, 부피나 직사각형의 가로, 세로, 넓이를 속성으로 갖는 클래스를 구현하라.
 부피나 넓이를 리턴하는 메소드 getVolume(), 출력하는 메소드 vPrint()도 구현한다.
데이터 : 가로, 세로, 높이, volume(부피or넓이)
메소드 : int getVolume(), void vPrint()
1. 데이터 선언(private)
2. 디폴트 생성자 public className(){}
3. 내가 원하는 변수 생성자(2개 짜리 변수 생성자, 3개 짜리 등등)
4. 메소드(내가 원하는)
*/
public class BoxOrRect {
	//데이터 부문
	private int width;
	private int height;
	private int depth; // box의 경우 깊이, rect일 경우는 0
	private int volume; // box의 경우 부피, rect의 경우 넓이
	//데이터 부문
	
	// 디폴트 생성자(마우스 우클릭 후 소스 제너레이트 form superclass)
	public BoxOrRect() {} 
	
	//변수 2개짜리 생성자
	//동일하게 마우스 우클릭 및 from Using Field 선택
	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
		volume = width*height;
	}
	//변수 3개짜리 생성자
	public BoxOrRect(int width, int height, int depth) {
	
		this.width = width;
		this.height = height;
		this.depth = depth;
		volume = width*height*depth;
	}
	//메소드 : volume 값 반환 시키는
	public int getVolume() {
		return volume;
	}
	//메소드 : 부피 혹은 넓이 값 프린트 해주는
	public void vPrint() {
		if(depth!=0) {
			System.out.println("부피는"+volume);
		}else {
			System.out.println("넓이는"+volume);
		}

	}
}
