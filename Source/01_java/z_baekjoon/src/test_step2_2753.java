import java.util.Scanner;

public class test_step2_2753 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		if(x%4==0 && (x%100!=0 || x%400==0)) {
			x=1;
		}else {
			x=0;
		}
		System.out.println(x);
	}
}
