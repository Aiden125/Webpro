package com.lec.ex1_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. �Է¿� ���� ����(��Ʈ����ü ����)
// 2. ������ �б�(read()-1byte��)(read(byte[]) byte[]��ŭ �б�)
// 3. �Է¿� ���� Ŭ����(��Ʈ�� ��ü ����)
public class Ex02_inputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); //1�� ���Ͽ���.
			byte[] bs = new byte[10];
			while(true) { //2�� ������ �б�.
				int readByteCount = is.read(bs); //10���� ����Ʈ�� ����� ������ readByteCount ���� 10�� ��. 2����Ʈ�� ������ 2�� ����
				if(readByteCount == -1) { //���� ���̸� -1�� �Ǳ⿡ ���� ������ ����
					break;
				}
				for(int i=0 ; i<readByteCount ; i++) { //�Ϲ�for���� ���ԵǸ� i���� ������ �������� �� �ֱ� ������ �迭���ΰ� �ƴ� byte���� �����ؼ� ��°���
					System.out.print((char)bs[i]);
				}
				//�̷��� ������ �� ������ ������ �̰ɷ� �Ⱦ�. Hi4567�̷������� �� ����
				//Ȯ��for���� ��� byte�迭���� ������ �ϱ� ������ �迭�� �� �´°� �ƴϸ� �̻��Ѱ� ����
//				for(byte b : bs) {
//					System.out.print((char)b);
//				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {//3.���ϴݱ�
				if(is!=null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
