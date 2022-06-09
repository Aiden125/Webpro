package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//hashmap�� �ε���, ������ ������ ����
public class Ex01_HashMap {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		System.out.println(list.get(0)); //list�迭�� collection�� index�� get��
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(11, "str11"); //11key���� ������ srt11���� but, �ε����� ����
		hashMap.put(20, "str20"); //20key���� ���εǴ� ������ "str20"�߰�
		hashMap.put(33, "str33");
		System.out.println(hashMap.get(20)); //key������ ������ get
		System.out.println("romove �� : " + hashMap);
		hashMap.remove(20); //remove�ȿ��� �ݵ�� key���� �־������
		System.out.println("romove �� : " +hashMap);
		hashMap.clear(); //�ؽ��� �ȿ� �ִ� ������ ���ֱ�. �����ϰ� �����. ������� ���� �ִ� ����
		System.out.println(hashMap.isEmpty()? "������ ��� ������ ����" : "������ ���� �ִ� ����");
		hashMap.put(0, "Hong gildong");
		hashMap.put(10, "Kim dongil");
		hashMap.put(22, "Lee soonsin");
		hashMap.put(40, "Yu jaeseok");
		System.out.println(hashMap);
		Iterator<Integer> iterator = hashMap.keySet().iterator(); //Iterator�� �̿��� Ű�¸� ������ ����.
		while(iterator.hasNext()) { //iterator�� ���� key���� ������ �ݺ�, Ű �̾Ƴ���
			Integer key = iterator.next();
			System.out.println(key + "�� �����ʹ�" + hashMap.get(key));
		}
	}
}
