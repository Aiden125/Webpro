package com.lec.ex5_lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class BookLib implements ILendable {
	private String bookNo; //å��ȣ
	private String bookTitle; //å�̸�
	private String writer; //����
	private String borrower; //������
	private Date checkOutDate; //������
	private byte state; //�������̸� 1 �ƴϸ� 0
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	// BookLib book = new BookLib("91a-01", "java", "�̰���");
	// book.checkOut("ȫ�浿") : �������� Ȯ�� -> ������� -> �����������
	@Override
	public void checkOut(String borrower) throws Exception {
		if(state==STATE_BORROWED) { //state==1 ��, �������� ���¸� ���ϴµ�, ����� �Ⱦ��⿡ ��� ���� �̿�
			throw new Exception(bookTitle + "������ �ڴ����ߡ��Դϴ�."); //������ ���� �߻�
		}
		//�������(����� �����Դٴ°� state�� 1�� �ƴ϶�� ��. �� ���� �����ϴٴ� ��
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		//�Ʒ� �������� Date�� ��ȯ���ֱ�
		//java������ ����Ǿ����ϴ�. ������:ȫ�浿 / ������:2022-4-4(��) / 2�� �̳��� �ݳ��ϼ���
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d(E)");
		System.out.println("\"" + bookTitle + "\" ������ ���� �Ǿ����ϴ�");
		System.out.println("������ : "+borrower + " / ������ : "+sdf.format(checkOutDate) + "2�� ���� �ݳ��ϼ���");
	}
	//book.checkIn() : �������� Ȯ�� -> ��ü���� Ȯ�� -> ��ü�Ǿ��� ��� ��ü�� ����y/n -> �ݳ����� -> �����������
	@Override
	public void checkIn() throws Exception {
		if(state == STATE_NORMAL) {
			throw new Exception(bookTitle + "������ �������� �ƴ� �����Դϴ�");
		}
		//��ü���� Ȯ�� checkOutDate ~ ������� 14�� �̳����� ����
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime(); //����������� ��������� �и�����
		long day = diff / (1000*60*60*24); //�и������� ��¥�� ������ֱ� ���� ����
		if(day > 14) { //��ü����
			System.out.println("��ü��� ���� 100�� �ΰ��˴ϴ�. ���ž��� ��ü��� " + (day-14)*100 + "�� �Դϴ�.");
			Scanner scanner = new Scanner(System.in);
			System.out.print("��ü�Ḧ ���̳���?(Y/N)");
			if(! scanner.next().equalsIgnoreCase("y")) { // Y�� �Է����� ���� ���
				System.out.println("��ü�Ḧ ���ž� �ݳ�ó���� �����մϴ�.");
				return; //return�� �Ἥ ���� ������ �������� �ʰ�.
			}
		}
		//�ݳ�����(��ü�� �ȵ� ��쿡 �ش�Ǳ� ������)
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+bookTitle+"\"������ �ݳ��Ǿ����ϴ�.");
	}
	//sysout(book) -> å��ȣ:91a-01 / å�̸�:java / ����:�̰��� ���Ⱑ��
	//			   -> å��ȣ:91a-01 / å�̸�:java / ����:�̰��� ������(������:2022-4-4(��))
	@Override
	public String toString() {
		String msg = "å��ȣ : " + bookNo + "\tå �̸� : " +bookTitle + "\t���� : " + writer;
		msg += (state == STATE_NORMAL)? " ���Ⱑ��" : " ������";
		if(state == STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("(������ : yyyy-M-d(E))");
			msg += sdf.format(checkOutDate);
			//�������� + 14�� => ���� �Ѿ�� �ȳ��ͼ� �ϴ� �����Ϸ� ���
//			Date date = new Date(checkOutDate.getTime()+(1000*60*60*24*14)); //���� �� ����
//			SimpleDateFormat sdf = new SimpleDateFormat("(�ݳ������� : yyyy-M-d(E))");
//			msg += sdf.format(date);
		}
		return msg;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
}
