package com.lec.ex5_homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		ArrayList<Member> member = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		OutputStream os = null;

		while (true) {
			System.out.println("회원리스트를 추가하시겠습니까? 시작은 아무 키, 중지는N/n");
			String answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			}
			System.out.println("이름을 입력하세요");
			String name = sc.next();
			System.out.println("번호를 입력하세요");
			String tel = sc.next();
			System.out.println("생년월일을 입력하세요(ex:1995-12-05)");
			//만약 잘못입력하는 경우 랭쓰를 이용해서 경고
			String birth = sc.next();
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			String today = sdf.format(now);
			String spb = birth.substring(5);
			if(today.equals(spb)) {
				System.out.println("축하축하");
			}
			System.out.println("주소를 입력하세요(ex:서울시 노원구)");
			sc.nextLine();
			String address = sc.nextLine();
			member.add(new Member(name, tel, birth, address));
		}
		try {
			os = new FileOutputStream("src\\com\\lec\\ex5_homework\\member.txt", true);
			for (Member m : member) {
				System.out.println(m);
				os.write(m.toString().getBytes()); //배열을 스트링으로 바꿔서 읽어오게 해주는 방법
			}
			if (!member.isEmpty()) {
				System.out.println("........이하  " + member.size() + "명 가입");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (Exception e2) {
				}
			}
		}
		if (member.isEmpty()) {
			System.out.println("가입된 회원이 없습니다.");
		}
		sc.close();
	}
}
