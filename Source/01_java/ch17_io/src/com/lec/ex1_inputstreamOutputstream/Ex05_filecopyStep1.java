package com.lec.ex1_inputstreamOutputstream;

import java.io.*;
// �̹����� �о�鿩�� �����غ���.
// 1. ��Ʈ����ü(�Է¿�, ��¿�)
// 2. �а� ����
// 3. ��Ʈ����ü �ݱ�(��Ʈ����ü.close)
// ���߿� ���� ��Ʈ����ü���� �ݱ��ؾߵ�
public class Ex05_filecopyStep1 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("d:\\WebPro\\����.jpg"); //1�ܰ�
			os = new FileOutputStream("d:/webPro/����_copyed.jpg"); //�������� �ι���� ������ �ѹ��� ������ �Ȱ��� �ǹ�
			int cnt = 0;
			while(true) { //2�ܰ�
				int i = is.read(); //1byte�� �б�
				if(i==-1) {
					break;
				}
				os.write(i);
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
