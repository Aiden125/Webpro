package com.lec.ex3_readerwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			//outTest���Ͽ� �ش� ������ �߰��ϴ� ����
			writer = new FileWriter("txtFile/outTest.txt", true);
			String msg = "\n\n�߰��� �ؽ�Ʈ �����Դϴ�. �ȳ��ϼ���";
			writer.write(msg);
			System.out.println("���� ��� ����");
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(writer!=null) writer.close();//3�ܰ�
			} catch (Exception ignore) { //���⼭ �������� ��찡 ���ٽ����ؼ� �����̸��� ignore�ε� ��
			}
		}
	}
}
