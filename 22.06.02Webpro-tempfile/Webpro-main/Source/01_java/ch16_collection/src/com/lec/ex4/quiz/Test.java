package com.lec.ex4.quiz;

import java.util.HashMap;
import java.util.Iterator;
// boolean 값이 들어가야되는 경우는 if때문에 걸러져 나온건지,
// break되어서 빠져나온건지 구분하기위해
public class Test {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0,  "str0");
		map.put(5,  "str10");
		Iterator<Integer> iterator = map.keySet().iterator();
		
		//추천방법
		if(map.get(5)!=null) {
			System.out.println("같은 번호가 있어서 put 불가");
		}
		
//		이렇게 하는 경우 불린 값을 써야됨
//		boolean ok = false;
//		while(iterator.hasNext()) {
//			Integer key = iterator.next();
//			if(key.equals(0)) {
//				ok = true;
//				break;
//			}
//		}
//		if(ok) {
//			System.out.println("같은 번호가 있어서 put불가");
//		}
	}
}
