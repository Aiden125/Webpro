package com.lec.ex1_inputstreamOutputstream;

import java.io.*;
// 이미지를 읽어들여서 복사해보기.(큰 바이트로)
// 1. 스트림객체(입력용, 출력용)
// 2. 읽고 쓰기
// 3. 스트림객체 닫기(스트림객체.close)
// 나중에 만든 스트림객체부터 닫기해야됨
public class Ex05_filecopyStep2 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("d:\\WebPro\\사진.jpg"); //1단계
			os = new FileOutputStream("d:/webPro/사진_copyed.jpg"); //역슬래시 두번대신 슬래시 한번도 괜찮음 똑같은 의미
			int cnt = 0;
			byte[] bs = new byte[1024]; //1024면 1키로바이트씩 읽는거
			while(true) { //2단계
				int readByteCount = is.read(bs); //1024byte씩 읽다가 마지막에 100byte를 읽어서 리드바이트에 100이 오는 그런식. 값이 조금이라도 있으면 -1은 아님.
				if(readByteCount==-1) { //파일 끝인지 여부
					break;
				}
				os.write(bs, 0, readByteCount); // bs로 읽어가는데, 0번 인덱스부터 readByteCount만큼 쓴다. 즉 1024바이트 읽고쓰고, 1024바이트 읽고쓰고, 100바이트 읽고쓰고 형식
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
