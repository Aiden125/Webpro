package com.lec.ex1_inputstreamOutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
// �̹����� �о�鿩�� �����غ���.(���� ũ�⸦ �����ؼ� �� ���� ũ�⸸ŭ��)
// 1. ��Ʈ����ü(�Է¿�, ��¿�)
// 2. �а� ����
// 3. ��Ʈ����ü �ݱ�(��Ʈ����ü.close)
// ���߿� ���� ��Ʈ����ü���� �ݱ��ؾߵ�
public class Ex05_filecopyStep3 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File("d:\\WebPro\\����.jpg"); //���� ũ�� ������ ���ؼ�
			is = new FileInputStream("d:\\WebPro\\����.jpg"); //1�ܰ�
			os = new FileOutputStream("d:/webPro/����_copyed.jpg"); //�������� �ι���� ������ �ѹ��� ������ �Ȱ��� �ǹ�
			int cnt = 0;
			byte[] bs = new byte[(int)file.length()]; //file.length�� ���� �뷮�� ���ϸ�, �⺻���� long���̱⿡ int������ ����ȯ
			while(true) { //2�ܰ�
				int readByteCount = is.read(bs); //1024byte�� �дٰ� �������� 100byte�� �о �������Ʈ�� 100�� ���� �׷���. ���� �����̶� ������ -1�� �ƴ�.
				if(readByteCount==-1) { //���� ������ ����
					break;
				}
				os.write(bs, 0, readByteCount); // bs�� �о�µ�, 0�� �ε������� readByteCount��ŭ ����. �� 1024����Ʈ �а���, 1024����Ʈ �а���, 100����Ʈ �а��� ����
				cnt++;
			}
			System.out.println(cnt + "�� while�� ������ ���� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
