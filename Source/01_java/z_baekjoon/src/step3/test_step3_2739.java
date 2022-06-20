package step3;
import java.util.Scanner;

public class test_step3_2739 {
	public static void main(String[] args) {
		int x;
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		for(int i=1; i<=9; i++) {
			System.out.println(x + " * " + i + " = " + x*i);
		}
	}
}
