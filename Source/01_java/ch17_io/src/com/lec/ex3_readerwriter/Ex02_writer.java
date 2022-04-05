package com.lec.ex3_readerwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			//outTest파일에 해당 문장을 추가하는 과정
			writer = new FileWriter("txtFile/outTest.txt", true);
			String msg = "\n\n추가한 텍스트 파일입니다. 안녕하세요";
			writer.write(msg);
			System.out.println("파일 출력 성공");
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(writer!=null) writer.close();//3단계
			} catch (Exception ignore) { //여기서 오류나는 경우가 없다시피해서 변수이름을 ignore로도 함
			}
		}
	}
}
