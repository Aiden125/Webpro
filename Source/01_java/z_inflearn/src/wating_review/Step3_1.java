package wating_review;
import java.util.ArrayList;
import java.util.Scanner;

// 두 배열 합치기
public class Step3_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int[] b = new int[m];
		for(int i=0; i<m; i++) {
			b[i] = sc.nextInt();
		}
		int k1=0, k2=0;
		ArrayList<Integer> answer = new ArrayList<>();
		while(k1<n && k2<m) {
			if(a[k1] < b[k2]) {
				answer.add(a[k1]);
				k1++;
			}else{
				answer.add(b[k2]);
				k2++;
			}
		}
		while(k1<n) {
			answer.add(a[k1]);
			k1++;
		}
		while(k2<m) {
			answer.add(b[k2]);
			k2++;
		}
		
		for(int x : answer) {
			System.out.print(x+ " ");
		}
	}
}
