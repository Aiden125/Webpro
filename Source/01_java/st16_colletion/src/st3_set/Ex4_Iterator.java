package st3_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
//Arraylist������ iterator�� ������ ������ �� �Ⱦ�
public class Ex4_Iterator {
	public static void main(String[] args) {
		// list�迭 interator ���� ��
		ArrayList<String> list = new ArrayList<String>();
		list.add("STR");
		list.add("STR");
		System.out.println(list);
		Iterator<String> iterator1 = list.iterator();
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
		System.out.println(); //����
		for(String l : list) {
			System.out.println(l);
		}
		// �ʰ迭 interator ���� ��
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ȫ�浿", "010-1111-2222");
		map.put("���", "010-3241-2921");
		Iterator<String> iterator2 = map.keySet().iterator();
		while(iterator2.hasNext()) {
			//�Ʒ�ó�� Ű�� ���� �����ϰ� �ؾߵ��� next�� �ι��ϸ� Ű�� �������� ������ �޶���
			String key = iterator2.next();
			System.out.println(key + "Ű�� ������ : " + map.get(key));
//			System.out.println(iterator2.next() + "Ű�� ������ : " + map.get(iterator2.next()));
		}
		// set�迭 interator ���� ��
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
