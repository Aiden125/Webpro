package com.lec.ex03_point;

public class Point {
	//메인 함수에서는 int x, y; 이렇게도 하지만 class에서는 다 따로하는게 국룰
	private int x;
	private int y;
	public Point() {}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//Point p = new Point(1, 2);
	//p. pointPrint();
	//System.out.println(p.infoString());
	//System.out.println(p);
	public void pointPrint() {
		System.out.println("2차원 좌표 : x="+x+", y="+y);
	}
	public String infoString() {
		return "2차원 좌표 : x="+x+", y="+y;
	}
	@Override
	public String toString() { //override(toString함수 재정의)
		return "2차원 좌표 : x="+x+", y="+y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
