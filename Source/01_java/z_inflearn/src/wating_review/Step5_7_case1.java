package wating_review;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Q.contains(x) ---> q�� x�� ���ԵǾ��°�
public class Step5_7_case1 {
	public static void main(String[] args) {
		Step5_7_case1 T = new Step5_7_case1();
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		System.out.println(T.solution(a, b));
	}
	
	public String solution(String a, String b) {
		String answer = "YES";
		Queue<Character> Q = new LinkedList<>();
		for(char x : a.toCharArray()) { // �ʼ� ���� ����
			Q.offer(x);
		}
		for(char x : b.toCharArray()) { // ���� ����
			if(Q.contains(x)) { // ���� ���� ������ �ʼ��� �ִ� ���
				if(Q.peek() != x) {
					return "NO";
				}else {
					Q.poll();
				}
			}
		}
		if(!Q.isEmpty()) {
			return "NO";
		}
		return answer;
	}
}
