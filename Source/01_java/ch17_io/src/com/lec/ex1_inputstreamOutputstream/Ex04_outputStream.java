package com.lec.ex1_inputstreamOutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 1.��¿� ������ ����(��¿뽺Ʈ����ü ����)
// 2.write�Ѵ�
// 3.��¿� ������ �ݴ´�(��¿뽺Ʈ����ü ����)
public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try { //1��
			os = new FileOutputStream("txtFile/outTest.txt"); //(����/����)������ ������ ��������� ������ �����. ������ ���� ���� ���ܹ߻�
			//os = new FileOutputStream("txtFile/outTest.txt", true); ������ �ִ� ���¿��� (����/����, true)�� ���ԵǸ� ���Ͽ� ������ �߰�����(HelloHello)�̷�������
			// byte[] bs = {'H','e','l','l','o'}; ��������� ���������� ������ ����
			String str = "Hello, Java\n�� �ñ��� ��� �ǰ��ϼ���";
			byte[] bs = str.getBytes(); //��Ʈ���� ����Ʈ �迭�� �ٲٴ� �Լ�
			os.write(bs); //for���� �̷��� �ᵵ ��
			System.out.println("���� ��� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(os!=null)
				try { // �ܰ�
					os.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
