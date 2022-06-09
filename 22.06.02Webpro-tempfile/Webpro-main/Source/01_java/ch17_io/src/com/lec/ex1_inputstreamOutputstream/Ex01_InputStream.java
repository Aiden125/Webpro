package com.lec.ex1_inputstreamOutputstream;
//(1)	Input : ���� �����͸� �д´�. Ű������ �����͸� �д´�. ��Ʈ��ũ���� �����͸� �д´�(����)
//(2)	Output :���Ͽ� �����͸� ����. ����Ϳ� �����͸� ����(���). ��Ʈ��ũ�� �����͸� ����(����)

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. �Է¿� ������ ����(��Ʈ����ü ����)
// 2. �����͸� �д´�. read() �޼ҵ带 ���ؼ�
// 3. �Է¿� ������ �ݴ´�.(��Ʈ����ü ����) ������ �ȴ����� ������ �ȵ�
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is=null; //�Ʒ��� ������ �ߴ��� �ʱ�ȭ�� �Ǿ��־�� �ϱ� ������ null ������ �� ����
		//��ǲ��Ʈ���� �߻�Ŭ������ �ٷ� ��ü�� �������� ���� ����, ����Ŭ���� �� FileInputstream�� �̿���
		//������ ã�µ� ��ã�� ��쿡 ���� ����ó���� �ݵ�� �϶�� �߱� ������, �� ó���� �������.
		try {
			is = new FileInputStream("txtFile/inTest.txt"); //1�� ����
			while(true) { //�о��ֱ� ���� �ݺ���. ��� ������ �𸣴ϱ� while���� ������
				int i = is.read(); //2. �����͸� �д� ����. ����ó�� �϶�� �ϱ� ������ catch���� �ϳ� �� �����ִ� �ڵ��ϼ� ���� 1byte�� �б� i�� 4byte���� ���ڸ��� ������ 1byte�� �о���
				if(i==-1) { //������ ���̸� �ݺ��� break; ������ ���� �о��� �� -1�� ����
					break;
				}//if
				System.out.print((char)i + "(" + i + ")"); //i���� �ƽ�Ű �ڵ尡 ���ð��̱� ������ ���ڿ��� ����ȯ ���ֱ�.
			}//while
			System.out.println("\n��"); //���� �� �о����� �� ������ֱ�
		} catch (FileNotFoundException e) {
			System.out.println("������ �� ã�� ��� ����"+e.getMessage());
		} catch (IOException e) {
			System.out.println("������ �� �д� ��� ����"+e.getMessage());
		}
		//try�ȿ��ٰ� ������ ���ܰ� �߻����� ���� ��쿡�� ������ �ݾ����⿡ finally�� �ݱ� �ֱ� try�ȿ� �ִ°� �ƴ�!
		//is��ü�� ����� ������������� ���(������ ��ã�����) ���� ������ ���� �ʿ䰡 ���� ������ ������ �ۿ��� �������
		finally { //3. ������ �ݴ´�.
			try {
				if(is!=null) is.close(); //is�� �ܼ��� null�� �Ǿ������� nullpoint���� �߻��Ǳ⿡ if������ �������ֱ�.
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
}
