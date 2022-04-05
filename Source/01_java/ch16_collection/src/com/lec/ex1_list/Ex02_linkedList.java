package com.lec.ex1_list;
//LinkedList = 배열중간에 값을 끼워넣어야하는 일이 있을 때.
import java.util.ArrayList;
import java.util.LinkedList;

public class Ex02_linkedList {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("str0"); //0번 인덱스
		linkedList.add("str1"); //2번 인덱스
		linkedList.add("str2"); //3번 인덱스
		linkedList.add(1, "str3"); //1번 인덱스에 끼워넣기
		System.out.println(linkedList); 
		for(String list : linkedList) {
			System.out.println(list);
		}
		linkedList.clear();
		System.out.println(linkedList.isEmpty()? "데이터가 없습니다" : "데이터가 있습니다");
		
	}
}
