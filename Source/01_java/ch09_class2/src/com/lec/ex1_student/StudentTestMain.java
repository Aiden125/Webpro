package com.lec.ex1_student;

public class StudentTestMain {
	public static void main(String[] args) {
		Student[] student = {
				new Student("정우성", 90, 90, 90),
				new Student("김하늘", 90, 90, 91),
				new Student("황정민", 81, 80, 80),
				new Student("강동원", 80, 80, 80),
				new Student("유아인", 70, 70, 70)
				
				};
		int sum[];
		System.out.println("이름"+"\t"+"국어"+"\t"+"영어"+"\t"+"수학"+"\t"+"총점"+"\t"+"평균");
		for(int idx=0 ; idx<student.length ; idx++) {
			student[idx].print();
			
		}
	}
}
