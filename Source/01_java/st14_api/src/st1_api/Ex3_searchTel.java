package st1_api;

import java.util.Scanner;

// �迭�� �ִ� ��ȭ��ȣ ã�� ��ü ��ȭ��ȣ ���
public class Ex3_searchTel {
	public static void main(String[] args) {
		String[] tels = {"010-9999-9999" , "02-8888-8888" , "010-7777-8888"};
		Scanner sc = new Scanner(System.in);
		String searchTel ;  //����ڷκ��� ��ȭ��ȣ �޹�ȣ �Է� ���� ������ �Ҵ�
		
		//��ȭ��ȣ�� ã�Ҵ��� ��ã�Ҵ��� �������� ����Ī �����. false�� ��ã�� ����, true�� ã���ɷ� ���
		boolean searchOK = false;
		
		System.out.println("�˻��ϰ��� �ϴ� ȸ���� ��ȭ��ȣ ���ڸ���?");
		searchTel = sc.next(); // 1234
		for(int idx=0 ; idx<tels.length ; idx++) {
			//idx��°�� ��ȭ��ȣ ���ڸ� ����
			//post��� �޹�ȣ ������ �������ָ鼭 ���� ���̱�.
			String post = tels[idx].substring(tels[idx].lastIndexOf('-')+1);
			if(post.equals(searchTel)) {
				System.out.println("�˻��Ͻ� ��ȭ��ȣ��"+tels[idx]+"�Դϴ�");
				searchOK = true; //break�� ����ؼ� ������ �������ָ鼭 ���� ���
				//break; 
			}//if - ��ȭ��ȣ�� ã�� ��� �� �̻� �˻����� �ʰ� for�� ����������
		}//for
		if(! searchOK) { // searTel�� �迭 ��ȭ�� ��� �� ã�� idx�� ������ �� ���
			System.out.println("�˻��Ͻ� ��ȭ��ȣ�� �����ϴ�.");
		}
	}
}
