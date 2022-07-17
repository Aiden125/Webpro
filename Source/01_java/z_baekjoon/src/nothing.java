public class nothing {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = 3;
		for(int i=0; i<3; i++) {
			System.out.println(a);
			System.out.println("----------------");
			System.out.println(b);
			for(int j=0; j<3; j++) {
				if(i==0) {
					System.out.println("건너 뛰는 부분");
					continue;
				}
				System.out.println(c);
			}
		}
	}
}
