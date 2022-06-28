package step4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_step4_2577 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int a,b,c;
		double x;
		int a0 = 0, a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0, a7 = 0, a8 = 0, a9 = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		x = a*b*c;
		String xStr = Integer.toString((int) x);
		String temp = null;
		for(int i=1; i<=xStr.length(); i++) {
			temp = xStr.substring(i-1, i);
			if(temp.equals("0")) {
				a0++;
			}else if(temp.equals("1")) {
				a1++;
			}else if(temp.equals("2")) {
				a2++;
			}else if(temp.equals("3")) {
				a3++;
			}else if(temp.equals("4")) {
				a4++;
			}else if(temp.equals("5")) {
				a5++;
			}else if(temp.equals("6")) {
				a6++;
			}else if(temp.equals("7")) {
				a7++;
			}else if(temp.equals("8")) {
				a8++;
			}else if(temp.equals("9")) {
				a9++;
			}
			
		}
		System.out.printf("%d\n%d\n%d\n%d\n%d\n%d\n%d\n%d\n%d\n%d\n", a0, a1, a2, a3, a4, a5, a6, a7, a8, a9);
	}
}