package com.lec.ex1_inputstreamOutputstream;
//(1)	Input : 파일 데이터를 읽는다. 키보드의 데이터를 읽는다. 네트워크상의 데이터를 읽는다(전송)
//(2)	Output :파일에 데이터를 쓴다. 모니터에 데이터를 쓴다(출력). 네트워크상에 데이터를 쓴다(전송)

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. 입력용 파일을 연다(스트림객체 생성)
// 2. 데이터를 읽는다. read() 메소드를 통해서
// 3. 입력용 파일을 닫는다.(스트림객체 종료) 파일을 안닫으면 저장이 안됨
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is=null; //아래서 오류가 뜨더라도 초기화가 되어있어야 하기 때문에 null 값으로 꼭 지정
		//인풋스트림은 추상클래스라 바로 객체를 만들지는 못함 따라서, 하위클래스 중 FileInputstream을 이용함
		//파일을 찾는데 못찾는 경우에 대한 예외처리를 반드시 하라고 뜨기 때문에, 이 처리를 해줘야함.
		try {
			is = new FileInputStream("txtFile/inTest.txt"); //1번 과정
			while(true) { //읽어주기 위한 반복문. 몇번 읽을지 모르니까 while문을 돌려줌
				int i = is.read(); //2. 데이터를 읽는 문장. 예외처리 하라고 하기 때문에 catch절을 하나 더 더해주는 자동완성 선택 1byte씩 읽기 i는 4byte지만 빈자리를 갖더라도 1byte씩 읽어줌
				if(i==-1) { //파일의 끝이면 반복문 break; 파일의 끝을 읽었을 때 -1로 읽음
					break;
				}//if
				System.out.print((char)i + "(" + i + ")"); //i값의 아스키 코드가 나올것이기 때문에 문자열로 형변환 해주기.
			}//while
			System.out.println("\n끝"); //파일 다 읽었으면 끝 출력해주기
		} catch (FileNotFoundException e) {
			System.out.println("파일을 못 찾은 경우 예외"+e.getMessage());
		} catch (IOException e) {
			System.out.println("파일을 못 읽는 경우 예외"+e.getMessage());
		}
		//try안에다가 넣으면 예외가 발생되지 않을 경우에만 파일이 닫아지기에 finally에 닫기 넣기 try안에 넣는게 아님!
		//is객체가 제대로 만들어지지않은 경우(파일을 못찾은경우) 따로 파일을 닫을 필요가 없기 때문에 변수를 밖에다 빼줘야함
		finally { //3. 파일을 닫는다.
			try {
				if(is!=null) is.close(); //is가 단순히 null로 되어있으면 nullpoint예외 발생되기에 if문으로 구분해주기.
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
}
