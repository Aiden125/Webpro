package com.lec.ex6.homeworkmyself;
// ��� ��ü �������
// �����͸� �Է��ϴ� ����. �ؽ�Ʈ ���Ϸ� ��ȯ(���� �� ���� ���·� ������Ʈ���� �Ἥ ��ȯ�߱� ������)
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Output {
	public static void main(String[] args) {
		OutputStream ops = null;
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);
		String answer;

		try {
			ops = new FileOutputStream("src/com/lec/ex6/homeworkmyself/mem.txt");
			dos = new DataOutputStream(ops);

			while (true) {
				System.out.println("ȸ�������Ͻðڽ��ϱ�? ������N/n");
				answer = sc.next();
				if (answer.equalsIgnoreCase("n")) {
					break;
				}
				System.out.println("�̸��� �Է��ϼ���");
				dos.writeUTF(sc.next());
				System.out.println("��ȣ�� �Է��ϼ���");
				dos.writeUTF(sc.next());
				System.out.println("���� �Է��ϼ���");
				dos.writeUTF(sc.next());
				System.out.println("�ּҸ� �Է��ϼ���");
				sc.nextLine();
				dos.writeUTF(sc.nextLine());

			}
			System.out.println("�Է¿Ϸ�");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null)
					dos.close();
				if (ops != null)
					ops.close();
			} catch (IOException e) {
			}
		}sc.close();

	}
}
