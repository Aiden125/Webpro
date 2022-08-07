package z_test_pass;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 교육과정 설계
// Queue사용 필요
public class Step5_7 {
	public static void main(String[] args) {
		Step5_7 T = new Step5_7();
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		System.out.println(T.solution(a, b));
	}
	
	
	public String solution(String a, String b) {
		String answer = "YES";
		Queue<Character> q = new LinkedList<>();
		for(char x : a.toCharArray()) {
			q.offer(x);
		}
		for(char x : b.toCharArray()) {
			if(!(q.isEmpty()) && x == q.peek()) {
				q.poll();
			}
		}
		if(!q.isEmpty()) {
			return "NO";
		}
		return answer;
	}
}
