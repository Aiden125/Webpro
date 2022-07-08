import java.util.Scanner;

// 꼭 static을 써야 하는가?
// 가장 올바른 방법인가?
public class Step9_2447{
	public static void main(String[] args) {
		 int n;
		 Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		 square(n);
	}
	
	static String a = "";
	static String b = "";
	static String c = "";
	public static void square(int n) {
		int tempn = n/3;
		int tempn2 = n/3;
		String aa = a;
		String bb = b;
		String cc = c;
		if(n==3) {
			System.out.println("***");
			System.out.println("* *");
			System.out.println("***");
			return;
		}else{
			while(tempn==0) {
				a += "***";
				b += "* *";
				c += "***";
				tempn--;
			}
			System.out.print(aa+"\n"+bb+"\n"+cc);
			aa = "";
			bb = "";
			cc = "";
			tempn = tempn2;
			n = n-tempn2;
		}
	}
}
