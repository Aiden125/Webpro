package step6;
import java.util.Scanner;

public class step6_2908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int x, y;
		x = Integer.parseInt((a.charAt(2)+""+a.charAt(1)+""+a.charAt(0)));
		y = Integer.parseInt((b.charAt(2)+""+b.charAt(1)+""+b.charAt(0)));
		if(x>y) {
			System.out.println(x);
		}else {
			System.out.println(y);
		}
	}
}
