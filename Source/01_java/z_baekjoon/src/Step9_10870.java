import java.util.Scanner;

public class Step9_10870 {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println(fibonacci(n));
	}
	
	public static int fibonacci(int n) {
		int sum=0;
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else {
			sum += fibonacci(n-1) + fibonacci(n-2);
		}
		return sum;
	}
}
