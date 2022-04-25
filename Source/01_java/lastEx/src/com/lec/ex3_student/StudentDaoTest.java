package com.lec.ex3_student;

import java.util.ArrayList;

public class StudentDaoTest {
	public static void main(String[] args) {
		StudentDao dao = StudentDao.getInstance();
		
		
		StudentDto dto = dao.selectSno("2022002");
		if(dto==null) {
			System.out.println("�ش� �й��� ���� ����� �����ϴ�.");
		}else {
			System.out.println(dto);
		}
		
		ArrayList<StudentDto> dtos = dao.selectSname("������");
		if(!dtos.isEmpty()) {
			for(StudentDto d : dtos) {
				System.out.println(d);
			}
		}else {
			System.out.println("�ش��̸��� ���� ����� �����ϴ�.");
		}
	}
}
