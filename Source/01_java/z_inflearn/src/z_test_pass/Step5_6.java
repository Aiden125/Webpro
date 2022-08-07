package z_test_pass;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 공주구하기
public class Step5_6 {
	public static void main(String[] args) {
		Step5_6 T = new Step5_6();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(T.solution(n, k));
	}
	
	public int solution(int n, int k) {
		int answer = 0;
		int[] arr = new int[n];
		int x;
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			q.offer(i);
		}
		while(q.size()!=1) {
			for(int i=1; i<k; i++) {
				x = q.poll();
				q.offer(x);
			}
			q.poll();
		}
		answer = q.poll();
		
		return answer;
	}
}
