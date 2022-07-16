package step6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class step6_10809_case2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = "abcdefghijklmnopqrstuvwxyz";
		String s = br.readLine();
		for(int i=0; i<26; i++) {
			System.out.println(s.indexOf(a.charAt(i)));
		}
		// indexOf에서 숫자가 없을 시 -1을 반환한다.
	}
}
