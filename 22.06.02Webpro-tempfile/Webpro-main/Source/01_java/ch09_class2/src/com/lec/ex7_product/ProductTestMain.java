package com.lec.ex7_product;

public class ProductTestMain {
	public static void main(String[] args) {
		//프로덕트마다 고유 넘버 부착.
		//공유변수는 누적되기에 각각 일치 시키려면 객체생성 + 프린트 동시에 해야 올바르게 적용
		Product p1 = new Product();
		p1.infoPrint();
		Product p2 = new Product();
		p2.infoPrint();
		//System.out.println("Static 변수 = 클래스 변수 = 공유변수(일명 깍두기) count :"+Product.count);
	}
}
