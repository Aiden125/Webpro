import java.util.Scanner;

public class test_step2_9498 {
	public static void main(String[] args) {
		int x;
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		if(90<=x  && x<=100) {
			System.out.println("A");
		}else if(80<=x) {
			System.out.println("B");
		}else if(70<=x){
			System.out.println("C");
		}else if(60<=x) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
	}
}
