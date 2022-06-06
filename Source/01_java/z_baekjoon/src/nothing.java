import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class nothing {
	public static void main(String[] args) throws IOException {
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 StringTokenizer st = new StringTokenizer("¿À´Ã ³ª ¹ä °£´ÜÈ÷¸ÔÀ»°Ô");
		 while(st.hasMoreTokens()) {
			 bw.write(st.nextToken().charAt(0));
		 }
		 bw.close();
	}
}
