package step4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_step4_4344 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int c = Integer.parseInt(br.readLine());
		double total = 0;
		double cnt = 0;
		double avg = 0;
		
		for(int j=0; j<c; j++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			double arr[] = new double[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = Double.parseDouble(st.nextToken());
				total += arr[i];
			}
			avg = total/n;
			for(int i=0; i<n; i++) {
				if(arr[i]>avg) {
					cnt++;
				}
			}
			System.out.printf("%.3f%%\n", (cnt/n)*100);
			cnt = 0;
			avg = 0;
			total = 0;
		}
	}
}