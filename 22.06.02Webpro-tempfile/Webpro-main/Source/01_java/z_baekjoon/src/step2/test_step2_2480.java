package step2;
import java.util.Arrays;
import java.util.Scanner;

public class test_step2_2480 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		if(x==y && y==z) { //3개가 다 같은 경우
			System.out.println(10000+(x*1000));
		}else if(x==y || x==z) {
			System.out.println(1000+(x*100));
		}else if(y==z) {
			System.out.println(1000+(y*100));
		}else {
			if(x>y && x>z) {
				System.out.println(x*100);
			}else if(y>x && y>z) {
				System.out.println(y*100);
			}else {
				System.out.println(z*100);
			}
		}
	}
}

