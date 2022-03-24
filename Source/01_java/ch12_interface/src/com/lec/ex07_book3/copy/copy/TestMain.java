package com.lec.ex07_book3.copy.copy;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("a01", "java", "���ڹ�"),
						new BookLib("a02", "python", "���̼�"),
						new BookLib("a03", "oracle", "��⸮"),
						new BookLib("a04", "web", "�ߴٸ�"),
						new BookLib("a05", "mysql", "���޸�")};
		CDLib[] cds = { new CDLib("cd01", "java_cd", "a01"),
						new CDLib("cd02", "jsp_cd", "c01"),
						new CDLib("cd03", "ITtrend_cd", "e01"),
						new CDLib("cd03", "oracle_cd", "a03")};
		Scanner sc = new Scanner(System.in);
		//fn, idx�� ���⼭ ������ ������ for�� �ȿ��� �����ϸ� for���� ������ ������ ���� ����Ǳ� ������
		int fn; //��ɹ�ȣ(1:���� , 2:�ݳ� , 3:ålist , 0:����)
		int idx; //�����ϰų� �ݳ��Ϸ��� �� �� ��ȸ�� å�� index
		int j;
		String bookTitle, cdTitle, borrower, checkOutDate; //����ڿ��� ���� å�̸�, ������, ������
		
//		do {
//		System.out.println("1:���� , 2:�ݳ� , 3:ålist , 0:����");
//		fn = sc.nextInt();
//	}while(fn!=0);
		
		while(true) {
			System.out.println("1:å ���� , 2:CD���� , 3:å�ݳ� , 4:CD�ݳ� , 5:ålist, 6:CD list , 0:����");
			fn = sc.nextInt();
			if(fn==0) {
				break;
			}
			switch (fn) {
			case 1:
				System.out.print("�����ϰ��� �ϴ� å �̸���?");
				bookTitle = sc.next();
				for(idx=0 ; idx<books.length ; idx++) {
					if(bookTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx==books.length) {
					System.out.println("���� �������� �ʴ� �����Դϴ�.");
				}else {
					if(books[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("���� �������� �����Դϴ�.");
					}else {
						System.out.println("�����ڴ�?");
						borrower = sc.next();
						System.out.println("��������?");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
							for(j=0 ; j<cds.length ; j++) {
								if(books[idx].getBookNo().equals(cds[j].getBookNo())) {
									if(cds[j].getState() == CDLib.STATE_NORMAL) {
										System.out.println("å�� ��Ʈ��"+cds[j].getCdTitle()+"CD�� �ֽ��ϴ�. �����Ͻðڽ��ϱ�(y/n)?");
										String answer = sc.next();
										if(answer.equals("y")) {
											cds[j].checkOut(borrower, checkOutDate);
											System.out.println("----------------------------------------");
										}
								}	
							}
						}
					}
				}
				break;
				
			case 2: 
				System.out.print("�����ϰ��� �ϴ� CD �̸���?");
				cdTitle = sc.next();
				for(idx=0 ; idx<cds.length ; idx++) {
					if(cdTitle.equals(cds[idx].getCdTitle())) {
						break;
					}
				}
				if(idx==cds.length) {
					System.out.println("���� �������� �ʴ� CD�Դϴ�.");
				}else {
					if(cds[idx].getState() == CDLib.STATE_BORROWED) {
						System.out.println("���� �������� CD�Դϴ�.");
					}else {
						System.out.println("�����ڴ�?");
						borrower = sc.next();
						System.out.println("��������?");
						checkOutDate = sc.next();
						cds[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
				
			case 3: 
				System.out.print("�ݳ��� å �̸���?");
				bookTitle = sc.next(); 
				for(idx=0 ; idx<books.length ; idx++) {
					if(bookTitle.equals(books[idx].getBookTitle())) {
						break;	
					}
				}
				if(idx == books.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�.");
				}else {
					books[idx].checkIn();
				}
				break;
				
			case 4: 
				System.out.print("�ݳ��� CD �̸���?");
				cdTitle = sc.next();
				for(idx=0 ; idx<cds.length ; idx++) {
					if(cdTitle.equals(cds[idx].getCdTitle())) {
						break;	
					}
				}
				
				if(idx == cds.length) {
					System.out.println("�ش� CD�� �� �������� CD�� �ƴմϴ�.");
				}else {
					cds[idx].checkIn();
				}
				break;
				
			case 5:
				System.out.println("å list�� ������ �����ϴ�.");
				for(BookLib book : books) {
					book.printstate();
				}
				break;
			
			case 6:
				System.out.println("CD list�� ������ �����ϴ�.");
				for(CDLib cd : cds) {
					cd.printstate();
				}
				break;
				
			case 0: break;
			}
		}System.out.println("BYE");
		sc.close();
	}//main
}//class
