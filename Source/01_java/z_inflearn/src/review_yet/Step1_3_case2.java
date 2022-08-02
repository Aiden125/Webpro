package review_yet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step1_3_case2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int maxLen = -1;
		String temp;
		String answer = "";
		while(st.hasMoreTokens()) {
			temp = st.nextToken();
			if(temp.length() > maxLen) {
				maxLen = temp.length();
				answer = temp;
			}
		}
		System.out.println(answer);
	}
}
