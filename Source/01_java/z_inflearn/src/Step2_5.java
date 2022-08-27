import java.util.Scanner;

public class Step2_5 {
	public static void main(String[] args) {
		Step2_5 T = new Step2_5();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(T.Solution(n));
	}
	
	public int Solution(int n) {
		int answer = 0;
		int[] ch = new int[n+1];
		for(int i=2; i<=n; i++) {
			if(ch[i]==0) {
				answer++;
				for(int j=i; j<=n; j=j+i) {
					ch[j]=1;
				}
			}
		}
		return answer;
	}
}
