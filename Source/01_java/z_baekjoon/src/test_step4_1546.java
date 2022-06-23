import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_step4_1546 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		int max = -1;
		double score = 0.0;
		double totScore = 0.0;
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		for(int i=0; i<n; i++) {
			score = ((double)(arr[i]/max))*100;
			System.out.println(score);
			totScore += score;
		}
		System.out.println(max);
		System.out.println(totScore);
	}
}