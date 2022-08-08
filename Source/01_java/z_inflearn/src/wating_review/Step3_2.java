package wating_review;
import java.util.*;

public class Step3_2 {
	public static void main(String[] args) {
		Step3_2 T = new Step3_2();
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
		for(int x : T.solution(n, a, m, b)) {
			System.out.print(x+" ");
		}
	}
	
	public ArrayList<Integer> solution(int n, int[] a, int m, int[] b){
		ArrayList<Integer> answer= new ArrayList<>();
		Arrays.sort(a);
		Arrays.sort(b);
		int k1=0;
		int k2=0;
		while(k1<n && k2<m) {
			if(a[k1]<b[k2]) {
				k1++;
			}else if(a[k1]>b[k2]) {
				k2++;
			}else {
				answer.add(a[k1]);
				k1++; k2++;
			}
		}
		return answer;
	}
}
