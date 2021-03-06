package step4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test_step4_10818 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int a, count = 0, min = 1000001, max= -1000001;
		
		count = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<count; i++) {
			a = Integer.parseInt(st.nextToken());
			if(a<min) {
				min = a;
			}
			if(a>max) {
				max = a;
			}
		}
		bw.write(min+" "+max);
		bw.close();
	}
}