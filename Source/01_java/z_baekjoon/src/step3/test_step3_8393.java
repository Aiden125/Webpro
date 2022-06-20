package step3;
import java.util.Scanner;

public class test_step3_8393 {
	public static void main(String[] args) {
		int x;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		for(int i=1; i<=x; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
