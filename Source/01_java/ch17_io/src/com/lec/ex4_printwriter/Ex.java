package com.lec.ex4_printwriter;

import java.io.*;

public class Ex {
	public static void main(String[] args) {
		OutputStream os = null;
		Writer witer = null;
		PrintWriter printWriter = null; // 1byte짜리, 2byte상관없이 보조로 쓸 수 있음
		try {
//			os = new FileOutputStream("txtFile/outTest.txt", true); //기본 스트림
//			printWriter = new PrintWriter(os); //보조 스트림
			printWriter = new PrintWriter("txtFile/outTest.txt"); //기본스트림으로 쓸 수 있으나, 파일 append 불가
			//PrintWriter를 통해서 프린트기능을 똑같이 쓸 수 있음
			System.out.println("안녕하세요\n반갑습니다");
			printWriter.println("안녕하세요\n반갑습니다");
			
			System.out.print("print는 자동개행이 안돼서 개행추가\n");
			printWriter.print("print는 자동개행이 안돼서 개행추가\n");
			
			System.out.printf("%s \t %d \t %3d \t %.1f\n", "홍길동", 90, 91, 90.5);
			printWriter.printf("%s \t %d \t %3d \t %.1f\n", "홍길동", 90, 91, 90.5);
			
			System.out.printf("%s \t %d \t %3d \t %.1f\n", "백길동", 100, 100, 100.0);
			printWriter.printf("%s \t %d \t %3d \t %.1f\n", "백길동", 100, 100, 100.0);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(printWriter!=null) {
				printWriter.close();
			}
		}
	}
}
