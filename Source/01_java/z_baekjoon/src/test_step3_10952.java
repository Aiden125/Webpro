import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test_step3_10952 {
	public static void main(String[] args) throws IOException {
		int a, b;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()); // 테스트 갯수
			b = Integer.parseInt(st.nextToken()); // 비교대상
			if(a==0 && b==0) {
				break;
			}
			bw.write(a+b+"\n");
		}
		bw.close();
	}
}