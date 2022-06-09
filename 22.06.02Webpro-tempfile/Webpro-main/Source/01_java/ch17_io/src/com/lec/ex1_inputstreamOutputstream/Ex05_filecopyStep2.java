package com.lec.ex1_inputstreamOutputstream;

import java.io.*;
// �̹����� �о�鿩�� �����غ���.(ū ����Ʈ��)
// 1. ��Ʈ����ü(�Է¿�, ��¿�)
// 2. �а� ����
// 3. ��Ʈ����ü �ݱ�(��Ʈ����ü.close)
// ���߿� ���� ��Ʈ����ü���� �ݱ��ؾߵ�
public class Ex05_filecopyStep2 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("d:\\WebPro\\����.jpg"); //1�ܰ�
			os = new FileOutputStream("d:/webPro/����_copyed.jpg"); //�������� �ι���� ������ �ѹ��� ������ �Ȱ��� �ǹ�
			int cnt = 0;
			byte[] bs = new byte[1024]; //1024�� 1Ű�ι���Ʈ�� �д°�
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
