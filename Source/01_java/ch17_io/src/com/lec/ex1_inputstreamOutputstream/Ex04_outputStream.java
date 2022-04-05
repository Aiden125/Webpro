package com.lec.ex1_inputstreamOutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 1.출력용 파일을 연다(출력용스트림객체 생성)
// 2.write한다
// 3.출력용 파일을 닫는다(출력용스트림객체 종료)
public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try { //1번
			os = new FileOutputStream("txtFile/outTest.txt"); //(폴더/파일)파일이 없으면 만들어지고 있으면 덮어쓰고. 폴더가 없을 때는 예외발생
			//os = new FileOutputStream("txtFile/outTest.txt", true); 폴더가 있는 상태에서 (폴더/파일, true)를 쓰게되면 파일에 내용을 추가해줌(HelloHello)이런식으로
			// byte[] bs = {'H','e','l','l','o'}; 길어질수록 불편해지기 때문에 변경
			String str = "Hello, Java\n이 시국에 모두 건강하세요";
			byte[] bs = str.getBytes(); //스트링을 바이트 배열로 바꾸는 함수
			os.write(bs); //for문을 이렇게 써도 됨
			System.out.println("파일 출력 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(os!=null)
				try { // 단계
					os.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
