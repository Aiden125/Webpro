package com.lec.ex3_readerwriter;
//2바이트씩 가져오는 방법으로 한글이 안깨지게 하기 위한 방법
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_Reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");
			while(true) {
				int i = reader.read(); //기본으로 하면 2바이트씩 읽게 됨
				if(i==-1) {
					break;
				}
				System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(reader!=null) {
					reader.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
