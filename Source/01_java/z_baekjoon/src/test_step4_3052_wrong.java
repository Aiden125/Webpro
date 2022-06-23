import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_step4_3052_wrong {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int cnt = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<arr.length; i++) {
			arr[i] = (Integer.parseInt(br.readLine()))%42;
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<=i; j++) {
				if((arr[i] >= 0 && arr[i] == arr[j])) {
					cnt++;
					arr[i] = -1;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(10-cnt);
	}
}
// 배열문제 x
// if문에 문제가 있음