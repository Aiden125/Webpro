package com.lec.ex6_Member;

public class MemberTestMain {
	public static void main(String[] args) {
		Member[] member = new Member[3];
		member[0] = new Member("aaa", "x11", "ȫ�浿", "ho@naver.com", "���� ����", "1992-12-11", 'M');
		member[1] = new Member("ddd", "889", "�����", "ho@naver.com", "�λ�", "1992-12-11", 'M');
		member[2] = new Member("fff", "122", "������", "ho@naver.com", "����", "1992-12-11", 'M');
		
		//for Ȯ�幮
		for(Member i : member) {
			System.out.println(i.infoString());
		}
	}
}
