package step7;
import java.util.Scanner;

public class step7_2869 {
	public static void main(String[] args) {
		int a,b,v;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		v = sc.nextInt();
		while(true) {
			if(a==v) {
				System.out.println(1);
				break;
			}else if((v-a)%(a-b)==0){
				System.out.println((v-a)/(a-b)+1);				
				break;
			}else {
				System.out.println((v-a)/(a-b)+2);
				break;
			}
		}
	}
}
