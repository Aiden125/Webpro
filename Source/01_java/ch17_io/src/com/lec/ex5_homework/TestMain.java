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
			System.out.println("ȸ������Ʈ�� �߰��Ͻðڽ��ϱ�? ������ �ƹ� Ű, ������N/n");
			String answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			}
			System.out.println("�̸��� �Է��ϼ���");
			String name = sc.next();
			System.out.println("��ȣ�� �Է��ϼ���");
			String tel = sc.next();
			System.out.println("��������� �Է��ϼ���(ex:1995-12-05)");
			//���� �߸��Է��ϴ� ��� ������ �̿��ؼ� ���
			String birth = sc.next();
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			String today = sdf.format(now);
			String spb = birth.substring(5);
			if(today.equals(spb)) {
				System.out.println("��������");
			}
			System.out.println("�ּҸ� �Է��ϼ���(ex:����� �����)");
			sc.nextLine();
			String address = sc.nextLine();
			member.add(new Member(name, tel, birth, address));
		}
		try {
			os = new FileOutputStream("src\\com\\lec\\ex5_homework\\member.txt", true);
			for (Member m : member) {
				System.out.println(m);
				os.write(m.toString().getBytes()); //�迭�� ��Ʈ������ �ٲ㼭 �о���� ���ִ� ���
			}
			if (!member.isEmpty()) {
				System.out.println("........����  " + member.size() + "�� ����");
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
			System.out.println("���Ե� ȸ���� �����ϴ�.");
		}
		sc.close();
	}
}