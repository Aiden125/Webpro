package step8;
import java.util.Scanner;
// �Ѽ�
public class step8_1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(execute(n));
	}
	public static int execute(int n) {		
		int count;
		if(n<100) { // 99������ ��� �Ѽ�
			count = n;
		}else {
			count = 99;
			for(int i=100; i<=n; i++) {
				int a = i/100; // 100�� �ڸ�
				int b = (i/10)%10; // 10�� �ڸ�
				int c = i%10; // 1�� �ڸ�
				
				if((a-b) == (b-c)) {
					count++;
				}
			}
		}
		return count;
	}
}
