package com.lec.ex1_inputstreamOutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 1.출력용 파일을 연다(출력용스트림객체 생성)
// 2.write한다
// 3.출력용 파일을 닫는다(출력용스트림객체 종료)
public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try { //1번
			os = new FileOutputStream("txtFile/outTest.txt"); //(폴더/파일)파일이 없으면 만들어지고 있으면 덮어쓰고. 폴더가 없을 때는 예외발생
			//os = new FileOutputStream("txtFile/outTest.txt", true); 폴더가 있는 상태에서 (폴더/파일, true)를 쓰게되면 파일에 내용을 추가해줌(HelloHello)이런식으로
			byte[] bs = {'H','e','l','l','o'};
			//아래에 있는 os.write(bs); 와 같기 때문에 굳이 for문으로 길게 쓸 필요없음
//			for(int i=0 ; i<bs.length ; i++) { //2. write
//				os.write(bs[i]);
//			}
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
