package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.lec.ex1_string.Friend;

public class Ex06_FriendSimpleDateFormat {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("������", "010-2222-3333", "03-28"),
				new Friend("�ں���", "010-5555-3333", "04-20"),
				new Friend("�˹���", "010-1234-3333", "05-12")};
//		�˻��� ��ȭ��ȣ ���ڸ��� �Է¹޾� => �ý������κ��� ��¥�� �޾� "MM-dd" ��Ÿ���� String���� ��ȯ(simpledateformat�Ἥ)
//		0~������� �ش� ��ȭ��ȣ�� ������ ��� => 0~������� �ش� ���ϰ� ������ ��ȯ�� string "03-28"�̶� ������ ���
//		�˻��� ���� �ʾ� ��� ���ϸ� ���µ���� ��� => �ش� �����ڰ� ���� ����� ���ϸ� ���µ���� ���
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(today);
		System.out.println(todayStr);
		boolean searchOk = false;
		for(Friend friend : friends) {
			String birthday = friend.getBirthday(); // �ش� ��°�� ��ü ���� �� get
			if(birthday.equals(todayStr)) {
				System.out.println(friend);
				searchOk = true;
			}//if - �ش� �������̸� ���
		}//for
		if(!searchOk) { 
			System.out.println("���� ������ ģ���� �����ϴ�.");
		}
	}
}
