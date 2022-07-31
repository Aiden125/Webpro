package review_yet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// Q.offer(1) ---> Q�� 1 �ֱ�
// Q.poll(); ----> Q �������� ��������(���� ���� ����)
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
		for(int i=1; i<=n; i++) { // ���� ���ڱ��� Q�� �ֱ�
			Q.offer(i);
		}
		while(!Q.isEmpty()) { // Q�� ����������� �ݺ�
			for(int i=1; i<k; i++) { // �� �� �ٽ� �ֱ� 
				Q.offer(Q.poll());
			}
			Q.poll();
			if(Q.size()==1) { // ���� �ϳ� ������ answer�� ����
				answer = Q.poll();
			}
		}
		
		
		return answer;
	}
}
