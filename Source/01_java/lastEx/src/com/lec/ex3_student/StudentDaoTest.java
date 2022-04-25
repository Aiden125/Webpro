package com.lec.ex3_student;

import java.util.ArrayList;

public class StudentDaoTest {
	public static void main(String[] args) {
		StudentDao dao = StudentDao.getInstance();
		
		
		StudentDto dto = dao.selectSno("2022002");
		if(dto==null) {
			System.out.println("해당 학번을 가진 사람이 없습니다.");
		}else {
			System.out.println(dto);
		}
		
		ArrayList<StudentDto> dtos = dao.selectSname("아이유");
		if(!dtos.isEmpty()) {
			for(StudentDto d : dtos) {
				System.out.println(d);
			}
		}else {
			System.out.println("해당이름을 가진 사람이 없습니다.");
		}
	}
}
