import java.util.Arrays;

public class ex123123 {
	public static void main(String[] args) {
		int[] arr = {15,2,4};
		Arrays.sort(arr);
		int a = getMedian(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
