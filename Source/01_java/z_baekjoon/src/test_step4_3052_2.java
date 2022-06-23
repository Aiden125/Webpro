import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_step4_3052_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean arr[] = new boolean[42];
		int cnt = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<10; i++) {
			arr[Integer.parseInt(br.readLine())%42] = true;
		}
		for(int i=0; i<42; i++) {
			if(arr[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}