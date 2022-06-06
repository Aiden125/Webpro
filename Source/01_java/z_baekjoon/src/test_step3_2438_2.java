import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class test_step3_2438_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int x = Integer.parseInt(br.readLine());
		 for(int i=1; i<=x; i++) {
			 for(int j=1; j<=i; j++) {
				 bw.write("*");
			 }
			 bw.write("\n");
		 }
		 bw.flush();
		 bw.close();
	}
}