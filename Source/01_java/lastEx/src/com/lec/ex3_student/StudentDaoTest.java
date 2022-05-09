package com.lec.ex3_student;

import java.util.ArrayList;

public class StudentDaoTest {
	public static void main(String[] args) {
		StudentDao dao = StudentDao.getInstance();

		// (1) �й��˻�
		System.out.println("-----------------(1) �й��˻�----------------");
		StudentDto dto = dao.selectSno("2022001");
		if (dto == null) {
			System.out.println("�ش� �й��� ���� ����� �����ϴ�.");
		} else {
			System.out.println(dto);
		}

		System.out.println("\n-----------------(2) �̸��˻�----------------");

		// (2) �̸��˻�
		ArrayList<StudentDto> dtos = dao.selectSname("������");
		if (!dtos.isEmpty()) {
			for (StudentDto d : dtos) {
				System.out.println(d);
			}
		} else {
			System.out.println("�ش��̸��� ���� ����� �����ϴ�.");
		}

		System.out.println("\n-----------------(3) �����˻�----------------");

		// (3) �����˻�
		ArrayList<StudentDto> mdtos = dao.selectMname("��ǻ�Ͱ���");
		if (!mdtos.isEmpty()) {
			for (StudentDto d : mdtos) {
				System.out.println(d);
			}
		} else {
			System.out.println("�ش������� ���� ����� �����ϴ�.");
		}

		System.out.println("\n-----------------(4) �л��Է�----------------");

		// (4) �л��Է�
		dto = new StudentDto("��������", "ȫȫȫ", 100);
		int result = dao.insertStudent(dto);
		System.out.println(result == StudentDao.SUCCESS ? "�Է¼���" : "�Է½���");

		System.out.println("\n-----------------(5) �л���������----------------");

		// (5) �л���������
		dto = new StudentDto("��������", "���켺", 55, "2022001");
		result = dao.updateStudent(dto);
		System.out.println(result == StudentDao.SUCCESS ? "��������" : "�Է½���");

		System.out.println("\n-----------------(6) ��ü��ȸ----------------");

		// (6) ��ü��ȸ
		dtos = dao.selectAll();
		if (dtos.size() != 0) {
			for (StudentDto d : dtos) {
				System.out.println(d);
			}
		} else {
			System.out.println("��ϵ� ����� �����ϴ�");
		}

		System.out.println("\n-----------------(7) ��������ȸ----------------");

		// (7) ��������ȸ
		dtos = dao.selectSexpel();
		if (dtos.size() != 0) {
			for (StudentDto d : dtos) {
				System.out.println(d);
			}
		} else {
			System.out.println("������ ����� �����ϴ�");
		}

		System.out.println("\n-----------------(8) �л���������----------------");

		// (8) �л���������
		dto = new StudentDto("2022001");
		result = dao.updateSexpel(dto);
		System.out.println(result == StudentDao.SUCCESS ? "��������" : "�Է½���");

	}
}
