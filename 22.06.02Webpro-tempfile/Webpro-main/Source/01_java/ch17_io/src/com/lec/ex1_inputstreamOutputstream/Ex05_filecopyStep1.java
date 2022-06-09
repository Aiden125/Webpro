package com.lec.ex1_inputstreamOutputstream;

import java.io.*;
// 이미지를 읽어들여서 복사해보기.
// 1. 스트림객체(입력용, 출력용)
// 2. 읽고 쓰기
// 3. 스트림객체 닫기(스트림객체.close)
// 나중에 만든 스트림객체부터 닫기해야됨
public class Ex05_filecopyStep1 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("d:\\WebPro\\사진.jpg"); //1단계
			os = new FileOutputStream("d:/webPro/사진_copyed.jpg"); //역슬래시 두번대신 슬래시 한번도 괜찮음 똑같은 의미
			int cnt = 0;
			while(true) { //2단계
				int i = is.read(); //1byte씩 읽기
				if(i==-1) {
					break;
				}
				os.write(i);
				cnt++;
			}
			System.out.println(cnt + "번 while문 수행해 복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
