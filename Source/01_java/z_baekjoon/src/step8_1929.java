
import java.util.Scanner;

public class step8_1929 {
	public static boolean[] prime;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		getPrime(N);
		
		for(int i=0; i<prime.length)

		
		
	}
	
	public static void getPrime(int N) {
		prime = new boolean[N+1];
		
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
