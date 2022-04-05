package com.lec.ex3_readerwriter;

import java.io.*;

public class Ex03_BufferReader {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtFile/inTest.txt"); //1. �⺻��Ʈ�� ���� - ��������n�� ���ö����� �о���
			br = new BufferedReader(reader); //������Ʈ���� �⺻��Ʈ���� ���ؼ� �������
			int cnt = 0;
			while(true) {
				String linedata = br.readLine(); //2.���پ� �����͸� �о���
				if(linedata==null) {
					break;
				}
				System.out.println(cnt++ + linedata);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally { //3. ���ϴݱ� �ʼ�
			try {
				if(br != null) {
					br.close();
				}
				if(reader != null) {
					reader.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
