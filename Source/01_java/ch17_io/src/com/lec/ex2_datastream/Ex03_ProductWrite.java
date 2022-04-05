package com.lec.ex2_datastream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

//����Է� ����ڰ� n�� �Է��� ������. ��ǰ, ����, ����� �Է¹޾� ���� ���(�޸��忡�� ������ �ʴ� ���������Ϸ� �޾Ƽ� �ϴ°� ����)
public class Ex03_ProductWrite {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer;
		OutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			//���� ��Ű���� ���� ����¹��̰� true�� ���ϸ� ���������Ͱ� ���ư� �� �ֱ⿡ �� �ֱ�
			fos = new FileOutputStream("src/com/lec/ex2_datastream/product.dat", true);
			dos = new DataOutputStream(fos);
			while(true) {
				System.out.println("�Է��� ��� �� �ֽ��ϱ�?(Y/N)");
				answer = sc.next();
				if(answer.equalsIgnoreCase("n")) {
					break;
				}else if(answer.equalsIgnoreCase("y")) { //��ǰ��, ����, ����� ���Ϸ� ���
					System.out.println("��ǰ����?");
					dos.writeUTF(sc.next()); //�̷����ϸ� �ٷ� dos�� ���� ���� ��Ʈ������ ������ �� ����
					System.out.println("������?");
					dos.writeInt(sc.nextInt());
					System.out.println("��������?");
					dos.writeInt(sc.nextInt());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos!=null) {
					dos.close();
				}
				if(fos!=null) {
					fos.close();
				}
			} catch (Exception e) {
				
			}
		}
	}
}
