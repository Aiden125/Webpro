package st4_book;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Book[] books = {new Book("901��-101-2��", "java", "���ڹ�"),
				new Book("331��-122-2��", "python", "���̼�"),
				new Book("661��-199-2��", "oracle", "�þ�Ŭ"),
				new Book("231��-155-2��", "web", "�ߴٸ�"),
				new Book("651��-166-2��", "mysql", "��ť��")};
		 Scanner sc = new Scanner(System.in);
		 
		 //����� �����ؾ�  for���� �������� �����Ǳ⿡ ���� ����
		 int fn;//��ɹ�ȣ(1:����, 2:�ݳ�, 3:ålist, 0:����)
		 int idx;//�����ϰų� �ݳ��Ϸ��� �� �� ��ȸ�� å�� index
		 String bookTitle, borrower, checkOutDate;//����ڿ��� ���� å�̸�, ������, ���⳯¥
		 
		 while(true) {
			 System.out.println("1:����, 2:�ݳ�, 3:å����Ʈ, 0:����");
			 fn = sc.nextInt();
			 if(fn==0) {
				 break;
			 }
			 switch(fn) {
				 case 1: //����ó�� : 1.å�̸� �Է�  2.å��ȸ  3.å����Ȯ��  4.�������Է�  5.�������Է�  6.����޼ҵ� ȣ��
					 System.out.println("�����ϰ��� �ϴ� å �̸���?");
					 bookTitle = sc.next();
					 for(idx=0 ; idx<books.length ; idx++) {
						 if(bookTitle.equals(books[idx].getBookTitle())) {
							 break;
						 }
					 }
					 if(idx==books.length) {
						 System.out.println("���� �������� ���� �����Դϴ�.");
					 }else {
						 if(books[idx].getState() == Book.STATE_BORROWED) {
							 System.out.println("���� �������� �����Դϴ�.");
						 }else {
							 System.out.println("�����ڴ�?");
							 borrower = sc.next();
							 System.out.println("��������?");
							 checkOutDate = sc.next();
							 books[idx].chedckOut(borrower, checkOutDate);
						 }
					 }
					 break;
					 
				 case 2:
					 System.out.println("�ݳ��� å �̸���?");
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
				 case 3:
					 System.out.println("å����Ʈ�� ������ �����ϴ�.");
					 for(Book book : books) {
						 book.printstate();
					 }
					 break;
				 case 0: break;
			 }
		 }System.out.println("BYE");
		 
		 
	}
}
