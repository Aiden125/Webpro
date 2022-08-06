package wating_review;
import java.util.Scanner;

public class Step3_2_case1 {
	public int solution(int n, int[] arr) {
		int answer=0;
		int max = -1;
		for(int i=0; i<n; i++) {
			if(arr[i]>max) {
				answer++;
				max = arr[i];
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Step3_2_case1 T = new Step3_2_case1();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(T.solution(n, arr));
	}
}
