package com.lec.ex05;
//			   object(Ŭ���� ���� ����)
//             Super
//      Child1      Child2
// GrandChild
public class TestMain {
	public static void main(String[] args) {
		
		Super s = new Super();
		System.out.println(s.s);
		
		System.out.println(); //����
		
		Child1 c1 = new Child1();
		System.out.println("c1.s="+c1.s+"c1.c1="+c1.c1);
		
		System.out.println(); //����
		
		Child2 c2 = new Child2();
		System.out.println("c2.s="+c2.s+"c2.c2="+c2.c2);
//		System.out.println("c2.c1="+c2.c1); �Ұ���
		
		System.out.println(); //����
		
		GrandChild gc = new GrandChild(100);
		System.out.println("gc.s="+gc.s+"gc.c1="+gc.c1+"gc.gc="+gc.gc);
//		System.out.println("gc.c2="+gc.c2); �Ұ���
	}
}
