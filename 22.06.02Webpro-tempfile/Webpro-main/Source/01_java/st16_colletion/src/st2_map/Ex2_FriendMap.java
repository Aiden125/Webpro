package st2_map;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class Ex2_FriendMap {
	public static void main(String[] args) {
		HashMap<String, Friend> friends = new HashMap<String, Friend>();
		friends.put("010.2222.2222", new Friend("ȫ�浿", "010-2222-2222"));
		friends.put("010.3333.2222", new Friend("������", "010-3333-2222"));
		friends.put("010.1111.2222", new Friend("������", "010-1111-2222"));
		friends.put("010.7777.2222", new Friend("������", "010-7777-2222"));
		friends.put("010.8888.2222", new Friend("�ڹڹ�", "010-8888-2222", new Date(95,12,12)));
		Iterator<String> iterator = friends.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + "�� �����ʹ�" +friends.get(key));
		}
	}
}
