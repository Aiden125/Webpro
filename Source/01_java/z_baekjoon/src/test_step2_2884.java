import java.util.Scanner;

public class test_step2_2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		// 24�� 30������ �˶��� ���� ���
		// 45���� �ȵ� �� �˶��� ���� ���
		if(x==0 && y<45) {
			y=15+y;
			x=23;
		}else if(y<45) {
			y=15+y;
			x=x-1;
		}else {
			y=y-45;
		}
		System.out.println(x+" "+y);
	}
}
