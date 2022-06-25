package step3;
import java.util.Scanner;

public class test_step3_1110 {
	public static void main(String[] args) {
		int t = 0;
		Scanner sc = new Scanner(System.in);
		int startx = sc.nextInt();
		int newx = startx;
		
		while(true) {
			int left = newx / 10;
			int right = newx%10;
			newx = (right*10)+(left+right)%10;
			t++;
			if(newx == startx) {
				break;
			}
		}
		System.out.println(t);
	}
}