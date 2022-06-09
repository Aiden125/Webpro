package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//hashmap은 인덱스, 순서가 별도로 없음
public class Ex01_HashMap {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		System.out.println(list.get(0)); //list계열의 collection은 index로 get함
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(11, "str11"); //11key값에 데이터 srt11저장 but, 인덱스는 없음
		hashMap.put(20, "str20"); //20key값에 매핑되는 데이터 "str20"추가
		hashMap.put(33, "str33");
		System.out.println(hashMap.get(20)); //key값으로 데이터 get
		System.out.println("romove 전 : " + hashMap);
		hashMap.remove(20); //remove안에는 반드시 key값을 넣어줘야함
		System.out.println("romove 후 : " +hashMap);
		hashMap.clear(); //해쉬맵 안에 있는 데이터 없애기. 깨끗하게 만들기. 껍데기는 남아 있는 상태
		System.out.println(hashMap.isEmpty()? "데이터 모두 삭제된 상태" : "데이터 남아 있는 상태");
		hashMap.put(0, "Hong gildong");
		hashMap.put(10, "Kim dongil");
		hashMap.put(22, "Lee soonsin");
		hashMap.put(40, "Yu jaeseok");
		System.out.println(hashMap);
		Iterator<Integer> iterator = hashMap.keySet().iterator(); //Iterator를 이용해 키셋만 빼오는 과정.
		while(iterator.hasNext()) { //iterator에 다음 key값이 있으면 반복, 키 뽑아내기
			Integer key = iterator.next();
			System.out.println(key + "의 데이터는" + hashMap.get(key));
		}
	}
}
