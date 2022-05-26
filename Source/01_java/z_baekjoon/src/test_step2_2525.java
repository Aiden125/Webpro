import java.util.Scanner;

public class test_step2_2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		// 시간, 분 둘 다 크게 안바뀌는 경우
		// 분이 60을 넘어가서 시간에 플러스 되는 경우
		// 시간이 24를 넘어가는 경우
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
