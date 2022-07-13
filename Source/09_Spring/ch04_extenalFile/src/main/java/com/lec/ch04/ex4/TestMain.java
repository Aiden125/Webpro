package com.lec.ch04.ex4;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String config = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("현재 dev? or run?");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("dev")){
			config = "dev";
		}else if(answer.equalsIgnoreCase("run")) {
			config = "run";
		}else {
			System.out.println("제대로 된 환경이 아님");
			System.exit(0);
		}
		sc.close();
		
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("classpath:META-INF/ex4/dev.xml", "classpath:META-INF/ex4/run.xml");
		ctx.refresh();
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println(info.getIpNum());
		System.out.println(info.getPortNum());
		System.out.println(info.getUserId());
		System.out.println(info.getUserPw());
	}
}
