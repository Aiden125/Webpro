package step8;
import java.util.Scanner;
// 한수
public class step8_1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(execute(n));
	}
	public static int execute(int n) {		
		int count;
		if(n<100) { // 99까지는 모두 한수
			count = n;
		}else {
			count = 99;
			for(int i=100; i<=n; i++) {
				int a = i/100; // 100의 자리
				int b = (i/10)%10; // 10의 자리
				int c = i%10; // 1의 자리
				
				if((a-b) == (b-c)) {
					count++;
				}
			}
		}
		return count;
	}
}
