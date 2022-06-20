package step3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test_step3_10951 {
	public static void main(String[] args) throws IOException {
		int a = 0, b = 0, temp = 0;
		int max = -9999;
		int t = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=1; i<=9; i++) {
			a = Integer.parseInt(br.readLine());
			for(int j=i+1; j<=i; j++) {
				b = Integer.parseInt(br.readLine());
				if(a > b) {
					temp = a;
					a = b;
					b = temp;
					t++;
				}
			}
		}
		System.out.println(a);
		System.out.println(t);		
	}
}