package com.lec.ch03.ex3;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch03.ex1.Family;

public class SingletonTestMain {
	public static void main(String[] args) {
		String location = "classpath:META-INF/ex3/applicationCTX.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		
		// family1,2는 family에서 주소를 받아와 가리키게 되기에 완전히 동일하다.
		Family family1 = ctx.getBean("family", Family.class);
		Family family2 = ctx.getBean("family", Family.class);
		
		family1.setPapaName("박아빠");
		family1.setMamaName("박엄마");
		
		System.out.println("family1 : " + family1);
		System.out.println("family2 : " + family2);
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		// family3,4는 각각 복사해서 가져오는거라서 직접 바꾼게 아니면 안바뀜
		// 즉, 아래와 같은 경우 복사해서 가져온다음 바꾼개념이 적용됨
		Family family3 = ctx.getBean("familyPrototype", Family.class);
		Family family4 = ctx.getBean("familyPrototype", Family.class);
		family3.setBrotherName("집나간 아들");
		family3.setSisterName("집에 있는 딸");
		System.out.println("family3 : " +family3);
		System.out.println("family4 : " +family4);
		ctx.close();
	}
}
