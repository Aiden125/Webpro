import java.io.BufferedReader;
import java.util.Scanner;

public class test_step3_15552 {
	public static void main(String[] args) {
		int x, y, t;
		BufferedReader br = new BufferedReader(t);
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int i=0; i<t; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			System.out.println(x+y);
		}
	}
}