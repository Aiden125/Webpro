import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test_step3_10871 {
	public static void main(String[] args) throws IOException {
		int n, a, x;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1, st2;
		
		st1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st1.nextToken()); // 테스트 갯수
		x = Integer.parseInt(st1.nextToken()); // 비교대상
		st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a = Integer.parseInt(st2.nextToken());
			if(a<x) {
				bw.write(a+"\n");
			}
		}
		bw.close();
	}
}