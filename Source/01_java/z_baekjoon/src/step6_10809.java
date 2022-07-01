import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class step6_10809 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		String s = br.readLine();
		int sw=0;
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<s.length(); j++) {
				if(a[i].equals(s.substring(j, j+1))){
					sw=1;
				}
			}
			if(sw==1) {
				System.out.println(s.indexOf(a[i]));
			}else {
				System.out.println(-1);
			}
		}
	}
}
