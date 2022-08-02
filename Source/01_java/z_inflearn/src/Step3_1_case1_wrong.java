import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step3_1_case1_wrong {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Step3_1_case1_wrong T = new Step3_1_case1_wrong();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		System.out.println(T.solution(n, st));
	}
	
	public int solution(int n, StringTokenizer st) {
		int answer = 0;
		for(int i=0; i<n; i++) {
			if(i==0) {
				System.out.println(Integer.parseInt(st.nextToken()));
			}
			
		}
		
		
		
		return answer;
	}
}
