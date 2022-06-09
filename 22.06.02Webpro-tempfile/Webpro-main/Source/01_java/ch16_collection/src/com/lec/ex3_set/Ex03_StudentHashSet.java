package com.lec.ex3_set;
// Student 파일과 함께봐야하는 파일.
import java.util.HashSet;
// HashSet을 쓰는데, new로 선언하더라도 객체값이 같다면
// 똑같이 취급하도록 하는방법. equals + hashCode + toString 오버라이드 해줘야함
public class Ex03_StudentHashSet {
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>();
		//아래의 두줄과
		Student s = new Student(6, "이순신");
		students.add(s);
		students.add(s); //이렇게 넣으면 새로 만들어주지 않기에 무쓸모
		//바로 아래 한줄이 같은 형식이지만 약간 다름.(밑에꺼는 무조건 새로 추가를 해주고 위에서처럼 하면 정보가 똑같으면 같은 객체로 인식해버림)
		students.add(new Student(3, "홍길동"));
		//같은 정보인데 또 넣고 싶다면 이렇게 꼭 넣어야함
		//하지만 만약 같은 걸로 인식시키고 싶다면 이퀄스 및 해쉬코드 오버라이드 해야함 -> Student 객체 참조할 것
		students.add(new Student(3, "홍길동"));
		students.add(new Student(6, "이순신"));
		System.out.println(students);
	}
}
