import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_step3_2439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x = Integer.parseInt(br.readLine());
		 for(int i=1; i<=x; i++) {
			 for(int j=x; j>=i+1; j--) {
				 sb.append(" ");
			 }
			 for(int k=1; k<=i; k++) {
				 sb.append("*");
			 }
			 sb.append("\n");
		 }
		 System.out.println(sb);
	}
}