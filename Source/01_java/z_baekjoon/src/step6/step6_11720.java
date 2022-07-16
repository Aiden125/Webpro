package step6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class step6_11720 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String a = br.readLine();
		long sum = 0;
		for(int i=0; i<n; i++) {
			sum += Integer.parseInt(a.substring(i, i+1));
		}
		System.out.println(sum);
	}
}
