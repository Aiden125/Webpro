import java.util.Scanner;

public class test_step2_2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		// �ð�, �� �� �� ũ�� �ȹٲ�� ���
		// ���� 60�� �Ѿ�� �ð��� �÷��� �Ǵ� ���
		// �ð��� 24�� �Ѿ�� ���
		if((y+z)<60) {//ok
			y = y+z;
		}else if((y+z)>=60 && (x+((y+z)/60))<24 ) {
			x = x+((y+z)/60);
			y = (y+z)%60;
		}else if((y+z)>=60 && (x+((y+z)/60))>=24 ) {
			x = (x+((y+z)/60))%24;
			y = (y+z)%60;
		}
		System.out.println(x+" "+y);
	}
}
