package st3_set;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Ex2_lottery {
	public static void main(String[] args) {
		HashSet<Integer> lottery = new HashSet<Integer>();
		//Ʈ������ ���� ������� ���Ű����ϳ�, �� �Ⱦ�
//		TreeSet<Integer> lottery = new TreeSet<Integer>();
		Random random = new Random();
		int cnt = 0;
		while(lottery.size()<6) {
			cnt++;
			lottery.add(random.nextInt(45)+1); //1~45������ ���� ���� add
		}
		System.out.println(cnt);
		System.out.println(lottery);
	}
}
