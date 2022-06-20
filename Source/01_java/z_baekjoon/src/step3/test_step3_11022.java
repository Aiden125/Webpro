package step3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test_step3_11022 {
	public static void main(String[] args) throws IOException {
		int x,y,t;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		t = Integer.parseInt(br.readLine()); // Å×½ºÆ® °¹¼ö
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			bw.write("Case #"+(i+1)+": " + x + " + " + y + " = " + (x + y) + "\n");
		}
		bw.close();
	}
}