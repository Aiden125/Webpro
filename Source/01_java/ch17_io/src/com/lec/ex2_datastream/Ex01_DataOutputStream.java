package com.lec.ex2_datastream;
//���� ������ ����ϴ°ǵ� �޸��忡 ������ �ʰ�. ���� ��Ʈ���� �̿��ϴ� ���
import java.io.*;
// 1. ��Ʈ����ü ����(������ ���°���)
// 2. ����(�޸��忡 ������ �ʰ�)
// 3. ��Ʈ����ü �ݱ�
public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream 	 fos = null;
		DataOutputStream dos = null; //�޸��忡 �Ⱥ��̱� ���ؼ�
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat", true); //�⺻��Ʈ�� Ȯ���� ��������� ����dat�� �ش��ϴ� �κ�
			dos = new DataOutputStream(fos); //������Ʈ���� �⺻��Ʈ���� ���ؼ��� ����
			// for.write(bs); �⺻��Ʈ���� ���� �޸������ε� ���̱� ������ �̸� ������Ʈ������ �����н����� 
			//�̸�-�г�-���� write
			dos.writeUTF("ȫ�浿"); // ��Ʈ���� �����Ҷ��� UTF�̿�
			dos.writeInt(2); // Int �̿��� �� ����
			dos.writeDouble(95.5); // Double �̿��� �� ����
			
			dos.writeUTF("������"); // ��Ʈ���� �����Ҷ��� UTF�̿�
			dos.writeInt(3); // Int �̿��� �� ����
			dos.writeDouble(94.5); // Double �̿��� �� ����
			System.out.println("���� ���� �Ϸ�");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos!=null); dos.close();
				if(fos!=null); fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
