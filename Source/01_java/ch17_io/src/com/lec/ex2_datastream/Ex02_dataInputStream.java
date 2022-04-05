package com.lec.ex2_datastream;

import java.io.*;

public class Ex02_dataInputStream {
	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("txtFile/dataFile.dat");
			dis = new DataInputStream(fis); // 보조스트림은 기본스트림을 통해서 생성
			while (true) {
				// 작성할 때의 순서대로 읽어들여야함
				String name = dis.readUTF();
				int grade = dis.readInt();
				double score = dis.readDouble();
				System.out.printf("[이름]%s \t [학년]%d [점수]%f\n", name, grade, score);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음" + e.getMessage());
		} catch (IOException e) {// 더 이상 파일을 읽어올게 없을 때
			System.out.println("이상 데이터 끝");
		} finally {
			try {
				if (dis != null) {
					dis.close();					
				}
				if (fis != null) {
					fis.close();					
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
