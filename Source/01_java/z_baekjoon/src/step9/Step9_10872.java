package step9;
import java.util.Scanner;

public class Step9_10872 {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println(factorial(n));
	}
	
	public static int factorial(int n) {
		int sum=1;
		if(n==1 || n==0) {
			return sum;
		}else {
			sum = n*factorial(n-1);
		}
		return sum;
	}
}
