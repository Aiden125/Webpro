package com.lec.ex4_object;

public class Ex05_Point3D {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p1 = new Point3D();
		p1.setX(10);
		p1.setY(20);
		p1.setZ(5);

		// 복제가 되었는지 안되었는지 판단하는 법.
		// 같게 나오는데(안에 있는 값은) 주소는 다르게 나와야함. 주소도 같다면 복제가 아닌 같은 곳을 가리키는 것
		Point3D p2 = (Point3D) p1.clone();
		System.out.println(p1.equals(p2) ? "같은 좌표" : "다른 좌표");
		System.out.println(p1 == p2 ? "복사한게 아니고 같은 주소" : "다른 주소");

		// if문으로도 구분 가능(복제했는지 아닌지)
		if (p1 != p2 && p1.equals(p2)) {
			System.out.println("복제성공");
		} else {
			System.out.println("복제실패");
		}
		
		//해쉬코드로도 구분 가능(복제했는지 아닌지)
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
	}
}
