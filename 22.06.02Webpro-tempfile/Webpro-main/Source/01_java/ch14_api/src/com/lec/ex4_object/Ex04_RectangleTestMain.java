package com.lec.ex4_object;

public class Ex04_RectangleTestMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle r1 = new Rectangle();
		r1.setHeight(10); r1.setWidth(5);
		//Rectangle r2 = r1; //이렇게 넣으면 같은 주소를 가리키는것이기 때문에 복제된 것이 아님(r1이 가리키는 주소를 r2도 가리키게 되는 것)
		Rectangle r2 = (Rectangle) r1.clone(); //r1과 똑같이 생긴r2를 만듦
		System.out.println("r1 : "+r1);
		System.out.println("r2 : "+r2);
		
		//복제가 되었는지 안되었는지 판단하는 법.
		//같게 나오는데(안에 있는 값은) 주소는 다르게 나와야함. 주소도 같다면 복제가 아닌 같은 곳을 가리키는 것
		System.out.println(r1.equals(r2)? "같은 사각형" : "다른 사각형");
		System.out.println(r1==r2 ? "복사한게 아니고 같은 주소를 가리킴":"다른 주소를 가리킴");
		
		//if문으로도 구분 가능(복제했는지 아닌지)
		if(r1!=r2 && r1.equals(r2)) {
			System.out.println("복제성공");
		}else {
			System.out.println("복제실패");
		}
		//해쉬코드로도 구분 가능(복제했는지 아닌지)
		System.out.println(r1.hashCode());
		System.out.println(r2.hashCode());
	}
}
