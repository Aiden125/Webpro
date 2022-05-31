package step2;
import java.util.Scanner;

public class test_step2_1330 {
	public static void main(String[] args) {
		int x,y;
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		if(x>y) {
			System.out.println(">");
		}else if(x<y) {
			System.out.println("<");
		}else {
			System.out.println("==");
		}
	}
}
