package com.lec.ex03_point;

public class Point {
	//���� �Լ������� int x, y; �̷��Ե� ������ class������ �� �����ϴ°� ����
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
		System.out.println("2���� ��ǥ : x="+x+", y="+y);
	}
	public String infoString() {
		return "2���� ��ǥ : x="+x+", y="+y;
	}
	@Override
	public String toString() { //override(toString�Լ� ������)
		return "2���� ��ǥ : x="+x+", y="+y;
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
