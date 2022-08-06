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
		int[] arr = new int[n]; // n개의 원소를 가진 배열
		for(int i=0; i<n; i++) { // 배열 값 채워주기
			arr[i] = sc.nextInt();
		}
		System.out.println(T.solution(m, n, arr));
	}
	
	
	public int solution(int m, int n, int[] arr) {
		int answer = 0;
		Queue<Person> Q = new LinkedList<>();
		for(int i=0; i<n; i++) { // 순서, 위험도 큐에 넣어주기
			Q.offer(new Person(i, arr[i]));
		}
		
		while(!Q.isEmpty()) { // 큐가 비어있을 때까지
			Person temp = Q.poll(); // 큐에서 하나빼서 temp에 담기
			for(Person x : Q) { // 뺀거랑 남은 Q랑 비교하기
				if(temp.priority<x.priority) { // 뺀거보다 남아있는게 우선순위가 높다면
					Q.offer(temp); // 다시 집어넣기
					temp = null; // temp null로 초기화
					break; // 끝내기
				}
			}
			if(temp!=null) { // 다 돌도고 temp값이 있다면 진료받을 차례를 뜻함
				answer++;
				if(temp.id==m) return answer;
			}
		}
		return answer;
	}
	
	class Person{ // {id, priority} 형태로 저장하는 객체
		int id;
		int priority;
		public Person(int id, int priority) {
			this.id=id;
			this.priority=priority;
		}
	}
	
}
