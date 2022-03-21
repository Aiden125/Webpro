package com.lec.ex03_point;

public class TestMain {
	public static void main(String[] args) {
		Point point = new Point(5,5); //x,y값 세팅(초기화)
		point.setX(10); //x값 10으로 재 세팅
		point.pointPrint();
		System.out.println(point.infoString());
		System.out.println(point.toString()); //System.out.println(point);과 같음 toString()이 자동으로 붙는 것이나 마찬가지
		//바로 밑 방법을 많이 씀. 즉, toString에 대해 이해를 잘 하고 있어야 한다는 것
		System.out.println(point); //위 와 출력 값이 같음 toString 오버라이딩해서 많이 쓰는 형태
		Point3D point3d = new Point3D(1, 2, 3);
		System.out.println(point3d.info3DString());
		System.out.println(point3d.infoString()); // 상속을 받으면 모든 멤버와 메소드를 다 상속
	}
}
