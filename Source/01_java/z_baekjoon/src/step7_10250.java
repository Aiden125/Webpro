import java.util.Scanner;

public class step7_10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테이트 케이스
		
		for(int i=0; i<T; i++) {
			int H = sc.nextInt(); // 높이
			int W = sc.nextInt(); // 넓이
			int N = sc.nextInt(); // 몇번째 손님인지
			if(N%H == 0) {
				System.out.print(H*100);
			}else {
				System.out.print(N%H);				
			}
			if(N/H < 9) {
				System.out.println("0"+((N/H)+1));							
			}else {
				System.out.println((N/H)+1);											
			}
		}
	}
}
