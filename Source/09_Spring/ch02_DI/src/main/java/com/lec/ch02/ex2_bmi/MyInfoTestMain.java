package com.lec.ch02.ex2_bmi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyInfoTestMain {
	public static void main(String[] args) {
		String resourseLocation = "applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourseLocation);
		// MyInfo myInfo = (MyInfo) ctx.getBean("myInfo");
		MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);
		myInfo.getInfo();
		ctx.close();
	}
}
