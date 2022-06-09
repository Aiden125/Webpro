package com.lec.ex3_student;

import java.util.ArrayList;

public class StudentDaoTest {
	public static void main(String[] args) {
		StudentDao dao = StudentDao.getInstance();

		// (1) 학번검색
		System.out.println("-----------------(1) 학번검색----------------");
		StudentDto dto = dao.selectSno("2022001");
		if (dto == null) {
			System.out.println("해당 학번을 가진 사람이 없습니다.");
		} else {
			System.out.println(dto);
		}

		System.out.println("\n-----------------(2) 이름검색----------------");

		// (2) 이름검색
		ArrayList<StudentDto> dtos = dao.selectSname("아이유");
		if (!dtos.isEmpty()) {
			for (StudentDto d : dtos) {
				System.out.println(d);
			}
		} else {
			System.out.println("해당이름을 가진 사람이 없습니다.");
		}

		System.out.println("\n-----------------(3) 전공검색----------------");

		// (3) 전공검색
		ArrayList<StudentDto> mdtos = dao.selectMname("컴퓨터공학");
		if (!mdtos.isEmpty()) {
			for (StudentDto d : mdtos) {
				System.out.println(d);
			}
		} else {
			System.out.println("해당전공을 가진 사람이 없습니다.");
		}

		System.out.println("\n-----------------(4) 학생입력----------------");

		// (4) 학생입력
		dto = new StudentDto("빅데이터학", "홍홍홍", 100);
		int result = dao.insertStudent(dto);
		System.out.println(result == StudentDao.SUCCESS ? "입력성공" : "입력실패");

		System.out.println("\n-----------------(5) 학생정보수정----------------");

		// (5) 학생정보수정
		dto = new StudentDto("빅데이터학", "정우성", 55, "2022001");
		result = dao.updateStudent(dto);
		System.out.println(result == StudentDao.SUCCESS ? "수정성공" : "입력실패");

		System.out.println("\n-----------------(6) 전체조회----------------");

		// (6) 전체조회
		dtos = dao.selectAll();
		if (dtos.size() != 0) {
			for (StudentDto d : dtos) {
				System.out.println(d);
			}
		} else {
			System.out.println("등록된 사람이 없습니다");
		}

		System.out.println("\n-----------------(7) 제적자조회----------------");

		// (7) 제적자조회
		dtos = dao.selectSexpel();
		if (dtos.size() != 0) {
			for (StudentDto d : dtos) {
				System.out.println(d);
			}
		} else {
			System.out.println("제적된 사람이 없습니다");
		}

		System.out.println("\n-----------------(8) 학생정보수정----------------");

		// (8) 학생정보수정
		dto = new StudentDto("2022001");
		result = dao.updateSexpel(dto);
		System.out.println(result == StudentDao.SUCCESS ? "수정성공" : "입력실패");

	}
}
