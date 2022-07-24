
import java.util.Scanner;

public class step8_1929 {
	public static boolean[] prime;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // 작은 수
		int N = sc.nextInt(); // 큰 수
		
		prime = new boolean[N+1];
		getPrime();
		
		for(int i= M; i<=N; i++) {
			if(!prime[i]) {
				System.out.println(i);
			}
		}

		
		
	}
	
	public static void getPrime(int N) {
		
		prime[0] = true;
		prime[1] = true;
		
		for(int i=2; i<=Math.sqrt(N); i++) {
			if(prime[i]==true) {
				continue;
			}
			
			
			for(int j=i; j<N+1; j+=i) {
				prime[j] = true;
			}
		}
	}
}
