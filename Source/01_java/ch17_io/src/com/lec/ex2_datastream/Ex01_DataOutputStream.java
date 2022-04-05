package com.lec.ex2_datastream;
//파일 내용을 출력하는건데 메모장에 보이지 않게. 보조 스트림을 이용하는 방법
import java.io.*;
// 1. 스트림객체 생성(파일을 여는과정)
// 2. 쓴다(메모장에 보이지 않게)
// 3. 스트링객체 닫기
public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream 	 fos = null;
		DataOutputStream dos = null; //메모장에 안보이기 위해서
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat", true); //기본스트림 확장자 내마음대로 지정dat에 해당하는 부분
			dos = new DataOutputStream(fos); //보조스트림은 기본스트림을 통해서만 생성
			// for.write(bs); 기본스트림을 쓰면 메모장으로도 보이기 때문에 이를 보조스트림으로 바이패스해줌 
			//이름-학년-점수 write
			dos.writeUTF("홍길동"); // 스트링값 저장할때는 UTF이용
			dos.writeInt(2); // Int 이용한 값 저장
			dos.writeDouble(95.5); // Double 이용한 값 저장
			
			dos.writeUTF("엄석대"); // 스트링값 저장할때는 UTF이용
			dos.writeInt(3); // Int 이용한 값 저장
			dos.writeDouble(94.5); // Double 이용한 값 저장
			System.out.println("파일 저장 완료");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos!=null); dos.close();
				if(fos!=null); fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
