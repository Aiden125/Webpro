package com.lec.ex6.homeworkmyself;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Input {
	public static void main(String[] args) {
		InputStream ios = null;
		DataInputStream dis = null;
		ArrayList<Member> members = new ArrayList<Member>();
		String name, phone, birth, address;

		try {
			ios = new FileInputStream("src/com/lec/ex6/homeworkmyself/mem.txt");
			dis = new DataInputStream(ios);

			while (true) {
				name = dis.readUTF();
				phone = dis.readUTF();
				birth = dis.readUTF();
				address = dis.readUTF();
				members.add(new Member(name, phone, birth, address));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dis != null)
					dis.close();
				if (ios != null)
					ios.close();
			} catch (Exception e2) {

			}
		}
		if (members.isEmpty()) {
			System.out.println("가입된 회원이 없습니다");
		} else {
			for (Member m : members) {
				System.out.println(m);
			}

		}

	}
}
