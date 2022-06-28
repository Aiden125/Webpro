package step4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_step4_8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int total = 0, cnt = 0;
		Character a;
		String x;
		for (int i = 0; i < n; i++) {
			x = br.readLine();
			for (int j = 0; j < x.length(); j++) {
				a = x.charAt(j);
				if (a.equals('O')) {
					cnt++;
					total += cnt;
				} else {
					cnt = 0;
				}
			}
			System.out.println(total);
			cnt = 0;
			total = 0;
		}
	}
}