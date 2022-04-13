package com.lec.ex5_homework.copy;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;
public class MemberTestMain_3_printWriter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer, name, phone, birth, address;
		int year,month, day;
		Date birthday;
		ArrayList<Member> members = new ArrayList<Member>();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now); // "04-06"
		do {
			System.out.print("ȸ������ �ϽǷ���(��, ������ ������ N)? ");
			answer = scanner.next();
			if(answer.equalsIgnoreCase("n")) break;
			System.out.print("ȸ���̸� ? ");
			name = scanner.next();
			System.out.print("��ȭ��ȣ ? ");
			phone = scanner.next();
			System.out.print("����(yyyy-MM-dd) ? ");
			birth = scanner.next();
			StringTokenizer token = new StringTokenizer(birth, "-");
			if(token.countTokens()==3) {
				year  = Integer.parseInt(token.nextToken());
				month = Integer.parseInt(token.nextToken());
				day   = Integer.parseInt(token.nextToken());
				//birthday = new Date(year-1900, month-1, day);
				birthday = new Date(new GregorianCalendar(year, month-1, day).getTimeInMillis());
			}else {
				System.out.println("���� ������ �ùٸ��� �ʽ��ϴ�. Ȯ���� �ּ���");
				continue;
			}
			if(today.equals(birth.substring(birth.indexOf("-")+1))) {
				System.out.println(name+"�� �����̽ñ���. ���������մϴ�");
			}
			System.out.print("�ּ� ? ");
			scanner.nextLine();
			address = scanner.nextLine();
			members.add(new Member(name, phone, birthday, address));
		}while(true);
		scanner.close();
		// 2. ArrayList ������ ��� �����ߴ��� ���� ��°� �ܼ� ����Ѵ�.
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter("src/com/lec/ex5_homework/member.txt");
			for(Member member : members) {
				System.out.print(member);
				printWriter.print(member.toString());
			}
			System.out.printf("\t\t\t...���� %d�� ����\n\n", members.size());
			printWriter.printf("\t\t\t...���� %d�� ����\n\n", members.size());
		} catch (FileNotFoundException e) {
			System.out.println("���� �� ã��"+e.getMessage());
		} catch (IOException e) {
			System.out.println("���� ����"+e.getMessage());
		}finally {
			try {
				if(printWriter!=null) printWriter.close();
			} catch (Exception ignore) { 
				System.out.println(ignore.getMessage());
			}
		}//try-catch-finally
	}
}