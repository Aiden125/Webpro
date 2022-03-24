package com.lec.ex07_book2.copy;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("901��-101-2��", "java", "���ڹ�"),
						new BookLib("331��-122-2��", "python", "���̼�"),
						new BookLib("661��-199-2��", "oracle", "��⸮"),
						new BookLib("231��-155-2��", "web", "�ߴٸ�"),
						new BookLib("651��-166-2��", "mysql", "���޸�")};
		Scanner sc = new Scanner(System.in);
		
		//fn, idx�� ���⼭ ������ ������ for�� �ȿ��� �����ϸ� for���� ������ ������ ���� ����Ǳ� ������
		int fn; //��ɹ�ȣ(1:���� , 2:�ݳ� , 3:ålist , 0:����)
		int idx; //�����ϰų� �ݳ��Ϸ��� �� �� ��ȸ�� å�� index
		String bookTitle, borrower, checkOutDate; //����ڿ��� ���� å�̸�, ������, ������
		
//		do {
//		System.out.println("1:���� , 2:�ݳ� , 3:ålist , 0:����");
//		fn = sc.nextInt();
//	}while(fn!=0);
		
		while(true) {
			System.out.println("1:���� , 2:�ݳ� , 3:ålist , 0:����");
			fn = sc.nextInt();
			if(fn==0) {
				break;
			}
			switch (fn) {
			case 1: // ����ó�� : 1.å�̸� �Է�   2.å��ȸ   3.å����Ȯ��   4.�������Է�   5.�������Է�   6.����޼ҵ� ȣ��
				System.out.print("�����ϰ��� �ϴ� å �̸���?");
				bookTitle = sc.next(); // white-space �ձ����� ��Ʈ���� ����
				for(idx=0 ; idx<books.length ; idx++) {
					if(bookTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}//å ��ȸ for
				if(idx==books.length) {
					System.out.println("���� �������� �ʴ� �����Դϴ�.");
				}else {//books[idx] ������ ���� ó��
					//3.å ����Ȯ��
					if(books[idx].getState() == BookLib.STATE_BORROWED) { //å ���� �Ұ�
						System.out.println("���� �������� �����Դϴ�.");
					}else { // ���� ���� ����
						//4.�������Է� 5.�������Է� 6.����޼ҵ� ȣ��
						System.out.println("�����ڴ�?");
						borrower = sc.next();
						System.out.println("��������?");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
				
			case 2: // �ݳ� : 1.å�̸�  2.å��ȸ  3.�ݳ�
				//1.å�̸�
				System.out.print("�ݳ��� å �̸���?");
				bookTitle = sc.next(); //å�̸� �Է¹޾� ���� ����
				//2.å��ȸ(Ȯ��for�� �Ⱦ��°� ����. index�� �����;��ϴ� ��Ȳ�̱⿡ Ȯ�幮�� ���� ������)
				for(idx=0 ; idx<books.length ; idx++) {
					if(bookTitle.equals(books[idx].getBookTitle())) {
						break;	
					}
				}
			
				if(idx == books.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�.");
				}else { //idx�� ã�� �� ��ġ. 3.�ݳ� ����
					books[idx].checkIn();
				}
				break;
			case 3:
				System.out.println("å list�� ������ �����ϴ�.");
				for(BookLib book : books) {
					book.printstate();
				}
				break;
			case 0: break;
			}
		}System.out.println("BYE");
		
	}//main
}//class
