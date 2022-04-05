package st3_set;

import java.util.HashSet;
import java.util.Iterator;
//HashSet 특정한 순서없이 단순히 배열에 집어넣는것. 출력도 랜덤으로 가능
public class Ex1_HashSet {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("str0");
		hashSet.add("str1");
		System.out.println(hashSet);
		hashSet.add("str1");
		System.out.println(hashSet);
		Iterator<String> iterator = hashSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
