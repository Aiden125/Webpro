package wating_review;
import java.util.Scanner;

public class Step3_3_case2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int answer=0, temp=0;
		for(int i=0; i<k; i++) { // answer = arr[0~k]
			answer += arr[i];
		}
		temp = answer;
		for(int i=k; i<n; i++) { // i가 4일 때 기존꺼 + arr[4] + arr[1]
			temp += (arr[i]-arr[i-k]);
			if(temp > answer) {
				answer = temp;
			}
		}
		System.out.println(answer);
	}
}
