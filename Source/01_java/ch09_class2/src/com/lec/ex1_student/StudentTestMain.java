package com.lec.ex1_student;

public class StudentTestMain {
	public static void main(String[] args) {
		Student[] student = {
				new Student("���켺", 90, 90, 90),
				new Student("���ϴ�", 90, 90, 91),
				new Student("Ȳ����", 81, 80, 80),
				new Student("������", 80, 80, 80),
				new Student("������", 70, 70, 70)
				
				};
		int sum[];
		System.out.println("�̸�"+"\t"+"����"+"\t"+"����"+"\t"+"����"+"\t"+"����"+"\t"+"���");
		for(int idx=0 ; idx<student.length ; idx++) {
			student[idx].print();
			
		}
	}
}
