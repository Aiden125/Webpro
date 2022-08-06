package wating_review;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Q.contains(x) ---> q에 x가 포함되었는가
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
		for(char x : a.toCharArray()) { // 필수 과목 순서
			Q.offer(x);
		}
		for(char x : b.toCharArray()) { // 현수 순서
			if(Q.contains(x)) { // 현재 현수 과목이 필수에 있는 경우
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
