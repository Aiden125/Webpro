package com.lec.ex4.quiz;

import java.util.HashMap;
import java.util.Iterator;
// boolean ���� ���ߵǴ� ���� if������ �ɷ��� ���°���,
// break�Ǿ �������°��� �����ϱ�����
public class Test {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0,  "str0");
		map.put(5,  "str10");
		Iterator<Integer> iterator = map.keySet().iterator();
		
		//��õ���
		if(map.get(5)!=null) {
			System.out.println("���� ��ȣ�� �־ put �Ұ�");
		}
		
//		�̷��� �ϴ� ��� �Ҹ� ���� ��ߵ�
//		boolean ok = false;
//		while(iterator.hasNext()) {
//			Integer key = iterator.next();
//			if(key.equals(0)) {
//				ok = true;
//				break;
//			}
//		}
//		if(ok) {
//			System.out.println("���� ��ȣ�� �־ put�Ұ�");
//		}
	}
}
