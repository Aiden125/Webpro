package com.lec.ex6.homeworkmyself;
// 멤버 객체 만들고나서
// 데이터를 입력하는 로직. 텍스트 파일로 반환(읽을 수 없는 형태로 보조스트림을 써서 반환했기 때문에)
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Output {
	public static void main(String[] args) {
		OutputStream ops = null;
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);
		String answer;

		try {
			ops = new FileOutputStream("src/com/lec/ex6/homeworkmyself/mem.txt");
			dos = new DataOutputStream(ops);

			while (true) {
				System.out.println("회원가입하시겠습니까? 중지는N/n");
				answer = sc.next();
				if (answer.equalsIgnoreCase("n")) {
					break;
				}
				System.out.println("이름을 입력하세요");
				dos.writeUTF(sc.next());
				System.out.println("번호를 입력하세요");
				dos.writeUTF(sc.next());
				System.out.println("생일 입력하세요");
				dos.writeUTF(sc.next());
				System.out.println("주소를 입력하세요");
				sc.nextLine();
				dos.writeUTF(sc.nextLine());

			}
			System.out.println("입력완료");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null)
					dos.close();
				if (ops != null)
					ops.close();
			} catch (IOException e) {
			}
		}sc.close();

	}
}
