package com.lec.ex1_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. 입력용 파일 오픈(스트림객체 생성)
// 2. 데이터 읽기(read()-1byte씩)(read(byte[]) byte[]만큼 읽기)
// 3. 입력용 파일 클로즈(스트림 객체 종료)
public class Ex02_inputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); //1번 파일열기.
			byte[] bs = new byte[10];
			while(true) { //2번 데이터 읽기.
				int readByteCount = is.read(bs); //10개의 바이트를 제대로 읽으면 readByteCount 값에 10이 들어감. 2바이트를 읽으면 2를 읽음
				if(readByteCount == -1) { //파일 끝이면 -1로 되기에 파일 끝인지 여부
					break;
				}
				for(int i=0 ; i<readByteCount ; i++) { //일반for문을 쓰게되면 i값을 개개로 지정해줄 수 있기 때문에 배열별로가 아닌 byte별로 지정해서 출력가능
					System.out.print((char)bs[i]);
				}
				//이렇게 넣으면 다 나오기 때문에 이걸로 안씀. Hi4567이런식으로 더 나옴
				//확장for문의 경우 byte배열별로 구분을 하기 때문에 배열이 딱 맞는게 아니면 이상한게 나옴
//				for(byte b : bs) {
//					System.out.print((char)b);
//				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {//3.파일닫기
				if(is!=null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
