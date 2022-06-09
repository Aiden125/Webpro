import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test_step3_10951 {
	public static void main(String[] args) throws IOException {
		int a, b;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		do {
			st = new StringTokenizer(br.readLine());
			if(st.hasMoreElements()) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				bw.write(a+b+"\n");
			}else {
				break;				
			}
		}while(true);
		bw.close();
	}
}