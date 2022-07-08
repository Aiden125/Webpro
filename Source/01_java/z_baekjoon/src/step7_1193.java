import java.util.Scanner;

public class step7_1193 {
	public static void main(String[] args) {
		int range=1;
		int count = 2;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n==1) {
			System.out.println(range);
		}else{
			while(range < n) {
				range += count;
				count++;
			}
		}// n = 4 / range = 2, 
	}
}
