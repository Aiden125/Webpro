package com.lec.ch03.ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String resourseLocation1 = "classpath:META-INF/ex1/applicationCTX1.xml";
		String resourseLocation2 = "classpath:META-INF/ex1/applicationCTX2.xml";

		// 경로에 하나를 넣어도 두개를, 몇개를 넣어도 상관없음
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourseLocation1, resourseLocation2);
		
		Student student = ctx.getBean("student", Student.class);
		System.out.println("student : " + student);

		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		System.out.println("studentInfo의 student : " + studentInfo.getStudent());
		 
		if(student.equals(studentInfo.getStudent())) {
		System.out.println("두 객체는 같은 객체"); }
 
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family);
		ctx.close(); // 컨테이너 소멸 = 컨테이너 안에 빈 자동소멸
	}
}
