package wating_review;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Step3_1_case2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Step3_1_case2 T = new Step3_1_case2();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(T.solution(n, arr));
	}
	
	public String solution(int n, int[] arr) {
		String answer = "";
		for(int i=0; i<n; i++) {
			if(i==0) {
				System.out.print(arr[0] + " ");
			}else {
				if(arr[i] > arr[i-1]) {
					answer += arr[i] + " ";
				}
			}
			
		}
		return answer;
	}
}
