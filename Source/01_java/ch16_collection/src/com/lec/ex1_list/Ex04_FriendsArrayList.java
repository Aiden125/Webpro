package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;

import com.lec.ex2_map.Friend;

public class Ex04_FriendsArrayList {
	public static void main(String[] args) {
		Friend[] friends = new Friend[5];
		friends[0] = new Friend("홍", "010-2222-3333");
		friends[2] = new Friend("김", "010-1111-3333");
		for(int i=0; i<friends.length ; i++) {
			System.out.println(friends[i]);
		}
		//ArrayList : index가 있고, 중복 허용
		//ArrayList의 경우 add를 통해 차곡차곡 쌓이기에 중간에 비어있는게 불가능 즉, 인덱스를 뛰어넘어서 추가할 수 없음
		ArrayList<Friend> fs = new ArrayList<Friend>();
		fs.add(new Friend("홍", "010-2222-3333")); //0번 인덱스
		fs.add(new Friend("김", "010-1111-3333")); //1번 인덱스 
		Friend temp = new Friend("이", "010-2345-7777", new Date(95,11,12));
		fs.add(temp); //2번 인덱스
		for(int i=0 ; i<fs.size() ; i++) {
			System.out.println(fs.get(i));
		}
	}
}
