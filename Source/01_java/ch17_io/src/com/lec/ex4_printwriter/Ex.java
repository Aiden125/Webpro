package com.lec.ex4_printwriter;

import java.io.*;

public class Ex {
	public static void main(String[] args) {
		OutputStream os = null;
		Writer witer = null;
		PrintWriter printWriter = null; // 1byte¥��, 2byte������� ������ �� �� ����
		try {
//			os = new FileOutputStream("txtFile/outTest.txt", true); //�⺻ ��Ʈ��
//			printWriter = new PrintWriter(os); //���� ��Ʈ��
			printWriter = new PrintWriter("txtFile/outTest.txt"); //�⺻��Ʈ������ �� �� ������, ���� append �Ұ�
			//PrintWriter�� ���ؼ� ����Ʈ����� �Ȱ��� �� �� ����
			System.out.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			printWriter.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			
			System.out.print("print�� �ڵ������� �ȵż� �����߰�\n");
			printWriter.print("print�� �ڵ������� �ȵż� �����߰�\n");
			
			System.out.printf("%s \t %d \t %3d \t %.1f\n", "ȫ�浿", 90, 91, 90.5);
			printWriter.printf("%s \t %d \t %3d \t %.1f\n", "ȫ�浿", 90, 91, 90.5);
			
			System.out.printf("%s \t %d \t %3d \t %.1f\n", "��浿", 100, 100, 100.0);
			printWriter.printf("%s \t %d \t %3d \t %.1f\n", "��浿", 100, 100, 100.0);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(printWriter!=null) {
				printWriter.close();
			}
		}
	}
}
