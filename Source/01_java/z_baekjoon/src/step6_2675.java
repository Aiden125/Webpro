import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class step6_2675 {
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String a = br.readLine();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a.charAt(i) == '"\'"')
				sb.append(a.charAt(0));
			}
		}
		
	}
}
