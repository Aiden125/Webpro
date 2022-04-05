package com.lec.ex1_inputstreamOutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 1.��¿� ������ ����(��¿뽺Ʈ����ü ����)
// 2.write�Ѵ�
// 3.��¿� ������ �ݴ´�(��¿뽺Ʈ����ü ����)
public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try { //1��
			os = new FileOutputStream("txtFile/outTest.txt"); //(����/����)������ ������ ��������� ������ �����. ������ ���� ���� ���ܹ߻�
			//os = new FileOutputStream("txtFile/outTest.txt", true); ������ �ִ� ���¿��� (����/����, true)�� ���ԵǸ� ���Ͽ� ������ �߰�����(HelloHello)�̷�������
			byte[] bs = {'H','e','l','l','o'};
			//�Ʒ��� �ִ� os.write(bs); �� ���� ������ ���� for������ ��� �� �ʿ����
//			for(int i=0 ; i<bs.length ; i++) { //2. write
//				os.write(bs[i]);
//			}
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
