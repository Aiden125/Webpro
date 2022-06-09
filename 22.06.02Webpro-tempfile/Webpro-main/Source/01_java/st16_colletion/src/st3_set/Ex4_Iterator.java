package st3_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
//Arraylist에서도 iterator를 쓸수는 있지만 잘 안씀
public class Ex4_Iterator {
	public static void main(String[] args) {
		// list계열 interator 쓰는 법
		ArrayList<String> list = new ArrayList<String>();
		list.add("STR");
		list.add("STR");
		System.out.println(list);
		Iterator<String> iterator1 = list.iterator();
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
		System.out.println(); //개행
		for(String l : list) {
			System.out.println(l);
		}
		// 맵계열 interator 쓰는 법
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("홍길동", "010-1111-2222");
		map.put("김삿갓", "010-3241-2921");
		Iterator<String> iterator2 = map.keySet().iterator();
		while(iterator2.hasNext()) {
			//아래처럼 키를 따로 지정하고 해야되지 next를 두번하면 키와 데이터의 정보가 달라짐
			String key = iterator2.next();
			System.out.println(key + "키의 데이터 : " + map.get(key));
//			System.out.println(iterator2.next() + "키의 데이터 : " + map.get(iterator2.next()));
		}
		// set계열 interator 쓰는 법
		HashSet<String> set = new HashSet<String>();
		set.add("str0");
		set.add("str1");
		set.add("str1");
		Iterator<String> iterator3 = set.iterator();
		while(iterator3.hasNext()) {
			System.out.println(iterator3.next());
		}
	}
}
