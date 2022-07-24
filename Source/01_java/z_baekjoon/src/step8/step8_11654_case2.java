package step8;

import java.util.Scanner;
// 소인수 분해 개선방법
public class step8_11654_case2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N==1) {
			
		}else {
			for(int i=2; i<=Math.sqrt(N); i++) {
				while(N%i==0) {
					System.out.println(i);
					N /= i;
				}
			}
			if(N!=1) {
				System.out.println(N);
			}
		}
		
	}
}
