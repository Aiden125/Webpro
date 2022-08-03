import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step1_4_case1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Step1_4_case1 T = new Step1_4_case1();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			sb.append(br.readLine());
			System.out.print(sb.reverse()+"\n");
			sb.setLength(0);
		}
	}
}
