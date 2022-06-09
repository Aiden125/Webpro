package com.lec.ex3_set;
//ex3파일과 연동
public class Student {
	private int grade;
	private String name;

	public Student(int grade, String name) {
		this.grade = grade;
		this.name = name;
	}

	@Override
	public String toString() {
		return grade + "학년 " + name;
	}
	// equals 와 hashcode override
	// 같은 값을 가지면 같다고 보이게 만들어 주려고
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Student) {
//			boolean gradeChk = grade == ((Student)obj).grade;
//			boolean nameChk = name.equals(((Student)obj).name);
//			return gradeChk && nameChk;
			//위 세줄과 아래 한줄이 같음
			return toString().equals(obj.toString());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}

}
