import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class step7_1712 {
	public static void main(String[] args) throws IOException {
		int a,b,c,cnt=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken()); // ������
		b = Integer.parseInt(st.nextToken()); // ������
		c = Integer.parseInt(st.nextToken()); // ����
		if(b>=c) {
			System.out.println(-1);
		}else {
			cnt = (a/(c-b))+1;
			System.out.println(cnt);
		}
	}
}
