package st3_set;

import java.util.HashSet;
import java.util.Iterator;
//HashSet Ư���� �������� �ܼ��� �迭�� ����ִ°�. ��µ� �������� ����
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
