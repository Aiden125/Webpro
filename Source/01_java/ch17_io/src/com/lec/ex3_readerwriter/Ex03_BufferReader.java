package com.lec.ex3_readerwriter;

import java.io.*;

public class Ex03_BufferReader {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtFile/inTest.txt"); //1. 기본스트림 생성 - 역슬래시n이 나올때까지 읽어줌
			br = new BufferedReader(reader); //보조스트림은 기본스트림을 통해서 만들어줌
			int cnt = 0;
			while(true) {
				String linedata = br.readLine(); //2.한줄씩 데이터를 읽어줌
				if(linedata==null) {
					break;
				}
				System.out.println(cnt++ + linedata);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally { //3. 파일닫기 필수
			try {
				if(br != null) {
					br.close();
				}
				if(reader != null) {
					reader.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
