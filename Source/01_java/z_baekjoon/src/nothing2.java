public class nothing2 {
	public static void main(String[] args) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(j==1) {
					continue;
				}
				System.out.println("i ��"+i);
				System.out.println("j ��"+j);
			}
			System.out.println("-------------");
		}
	}
}
