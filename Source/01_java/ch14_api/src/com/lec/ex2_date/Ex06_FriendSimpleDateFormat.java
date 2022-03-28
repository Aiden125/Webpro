package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.lec.ex1_string.Friend;

public class Ex06_FriendSimpleDateFormat {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("아이유", "010-2222-3333", "03-28"),
				new Friend("박보검", "010-5555-3333", "04-20"),
				new Friend("검버섯", "010-1234-3333", "05-12")};
//		검색할 전화번호 뒷자리를 입력받아 => 시스템으로부터 날짜를 받아 "MM-dd" 스타일의 String으로 변환(simpledateformat써서)
//		0~끝방까지 해당 전화번호가 있으면 출력 => 0~끝방까지 해당 생일과 위에서 변환한 string "03-28"이랑 같으면 출력
//		검색이 되지 않아 출력 못하면 없는데라고 출력 => 해당 생일자가 없어 출력을 못하면 없는데라고 출력
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(today);
		System.out.println(todayStr);
		boolean searchOk = false;
		for(Friend friend : friends) {
			String birthday = friend.getBirthday(); // 해당 번째의 객체 생일 값 get
			if(birthday.equals(todayStr)) {
				System.out.println(friend);
				searchOk = true;
			}//if - 해당 생일자이면 출력
		}//for
		if(!searchOk) { 
			System.out.println("오늘 생일인 친구가 없습니다.");
		}
	}
}
