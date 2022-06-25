package step1;
import java.util.Scanner;

public class test_step1_2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int a = ((y/100)*100);
		int b = (((y-a)/10)*10);
		int c = ((y-(a+b)));
		System.out.println((x*c));
		System.out.println((x*b)/10);
		System.out.println((x*a)/100);
		System.out.println(x*y);
	}
}

