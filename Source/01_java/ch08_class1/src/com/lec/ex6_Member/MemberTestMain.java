package com.lec.ex6_Member;

public class MemberTestMain {
	public static void main(String[] args) {
		Member[] member = new Member[3];
		member[0] = new Member("aaa", "x11", "홍길동", "ho@naver.com", "서울 강남", "1992-12-11", 'M');
		member[1] = new Member("ddd", "889", "국길수", "ho@naver.com", "부산", "1992-12-11", 'M');
		member[2] = new Member("fff", "122", "남길지", "ho@naver.com", "제주", "1992-12-11", 'M');
		
		//for 확장문
		for(Member i : member) {
			System.out.println(i.infoString());
		}
	}
}
