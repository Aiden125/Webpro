import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ex1231242 {
	public static void main(String[] args) throws IOException {
		int cnt1=0, cnt2=0; 
		for(int i=0; i<=10; i++) {
			cnt1 = i;
			cnt2 += cnt1;
		}
		System.out.println(cnt2);
	}
}
