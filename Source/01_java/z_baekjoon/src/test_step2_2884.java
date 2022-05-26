import java.util.Scanner;

public class test_step2_2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		// 24시 30분으로 알람을 맞춘 경우
		// 45분이 안될 때 알람을 맞춘 경우
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
