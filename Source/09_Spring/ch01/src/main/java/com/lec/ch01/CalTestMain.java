package com.lec.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalTestMain {

	public static void main(String[] args) {
//		Calculation cal = new Calculation();
//		cal.setNum1(50);
//		cal.setNum2(10);
		
		// 다른 클래스에서 만든 객체를 bean에서 지정해주고
		// 그걸 패싱 받는 것
		AbstractApplicationContext ctx =				
				new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Calculation cal = ctx.getBean("Calculation", Calculation.class);
		
		// 패싱 받아온걸 쓰는 것
		cal.add();
		cal.sub();
		cal.mul();
		cal.div();
		System.out.println(cal);
		
		// 패싱 받은걸 그만 받겠다.
		ctx.close();
	}
}
