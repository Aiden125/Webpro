package step7;
import java.util.Scanner;

public class step7_1712_case2 {
	public static void main(String[] args) {
		int a,b,c,cnt=0;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt(); // ������
		b = sc.nextInt(); // ������
		c = sc.nextInt(); // ����
		if(b>=c) {
			System.out.println(-1);
		}else {
			cnt = (a/(c-b))+1;
			System.out.println(cnt);
		}
	}
}
