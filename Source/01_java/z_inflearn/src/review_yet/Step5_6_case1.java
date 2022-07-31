package review_yet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// Q.offer(1) ---> Q에 1 넣기
// Q.poll(); ----> Q 마지막값 빼내오기(빼낸 값을 리턴)
public class Step5_6_case1 {
	public static void main(String[] args) {
		Step5_6_case1 T = new Step5_6_case1();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(T.solution(n, k));
	}
	
	public int solution(int n, int k) {
		int answer = 0;
		Queue<Integer> Q = new LinkedList<>();
		for(int i=1; i<=n; i++) { // 받은 숫자까지 Q에 넣기
			Q.offer(i);
		}
		while(!Q.isEmpty()) { // Q가 비었을때까지 반복
			for(int i=1; i<k; i++) { // 뺀 값 다시 넣기 
				Q.offer(Q.poll());
			}
			Q.poll();
			if(Q.size()==1) { // 값이 하나 남으면 answer에 저장
				answer = Q.poll();
			}
		}
		
		
		return answer;
	}
}
