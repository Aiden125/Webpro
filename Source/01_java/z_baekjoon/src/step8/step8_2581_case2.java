package step8;
import java.util.*;
public class step8_2581_case2{
	
	public static boolean prime[];
	
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	
    	int M = sc.nextInt(); // 작은 값
    	int N = sc.nextInt(); // 큰 값
    	
    	prime = new boolean[N+1]; // 배열 생성
    	get_prime();
    	
    	// 소수 합 및 최솟값
    	int sum = 0;
    	int min = Integer.MAX_VALUE;
    	for(int i=M; i<=N; i++) {
    		if(prime[i] == false){
    			sum += i;
    			if(min == Integer.MAX_VALUE) {
    				min = i;
    			}
    		}
    	}
    	if(sum == 0) {
    		System.out.println(-1);
    	}else {
    		System.out.println(sum);
    		System.out.println(min);
    	}
    }
    
    
    public static void get_prime() {
    	prime[0] = true;
    	prime[1] = true;
    	
    	for(int i = 2; i< Math.sqrt(prime.length); i++) {
    		for(int j=i*i; j<prime.length; j+=i ) {
    			prime[j] = true;
    		}
    	}
    }
}