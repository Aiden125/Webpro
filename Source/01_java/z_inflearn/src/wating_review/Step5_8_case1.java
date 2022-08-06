package wating_review;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Step5_8_case1 {
	public static void main(String[] args) {
		Step5_8_case1 T = new Step5_8_case1();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n]; // n���� ���Ҹ� ���� �迭
		for(int i=0; i<n; i++) { // �迭 �� ä���ֱ�
			arr[i] = sc.nextInt();
		}
		System.out.println(T.solution(m, n, arr));
	}
	
	
	public int solution(int m, int n, int[] arr) {
		int answer = 0;
		Queue<Person> Q = new LinkedList<>();
		for(int i=0; i<n; i++) { // ����, ���赵 ť�� �־��ֱ�
			Q.offer(new Person(i, arr[i]));
		}
		
		while(!Q.isEmpty()) { // ť�� ������� ������
			Person temp = Q.poll(); // ť���� �ϳ����� temp�� ���
			for(Person x : Q) { // ���Ŷ� ���� Q�� ���ϱ�
				if(temp.priority<x.priority) { // ���ź��� �����ִ°� �켱������ ���ٸ�
					Q.offer(temp); // �ٽ� ����ֱ�
					temp = null; // temp null�� �ʱ�ȭ
					break; // ������
				}
			}
			if(temp!=null) { // �� ������ temp���� �ִٸ� ������� ���ʸ� ����
				answer++;
				if(temp.id==m) return answer;
			}
		}
		return answer;
	}
	
	class Person{ // {id, priority} ���·� �����ϴ� ��ü
		int id;
		int priority;
		public Person(int id, int priority) {
			this.id=id;
			this.priority=priority;
		}
	}
	
}
