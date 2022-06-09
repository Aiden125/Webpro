package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;

import com.lec.ex2_map.Friend;

public class Ex04_FriendsArrayList {
	public static void main(String[] args) {
		Friend[] friends = new Friend[5];
		friends[0] = new Friend("ȫ", "010-2222-3333");
		friends[2] = new Friend("��", "010-1111-3333");
		for(int i=0; i<friends.length ; i++) {
			System.out.println(friends[i]);
		}
		//ArrayList : index�� �ְ�, �ߺ� ���
		//ArrayList�� ��� add�� ���� �������� ���̱⿡ �߰��� ����ִ°� �Ұ��� ��, �ε����� �پ�Ѿ �߰��� �� ����
		ArrayList<Friend> fs = new ArrayList<Friend>();
		fs.add(new Friend("ȫ", "010-2222-3333")); //0�� �ε���
		fs.add(new Friend("��", "010-1111-3333")); //1�� �ε��� 
		Friend temp = new Friend("��", "010-2345-7777", new Date(95,11,12));
		fs.add(temp); //2�� �ε���
		for(int i=0 ; i<fs.size() ; i++) {
			System.out.println(fs.get(i));
		}
	}
}
