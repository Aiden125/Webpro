package com.lec.ex4_object;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
//만약 부서에 대한 기록을 개인마다 다르게 한다면? 전산, 전산실, 컴퓨터 등등 각각 다르게 쓸 수 있기에 이를 방지해야한다. -약속된 String을 구현해보자
//Sawon s1 = new Sawon("a01", "홍길동", "Dept.COMPUTER") - 오늘 입사일 (static이 들어간 경우 클래스명.컴퓨터 이런식으로 써야함 예시는 앞에 있는 Dept.COMPUTER)
//Sawon s2 = new Sawon("a02", "아이유", "Dept.HUMANRECOURCES", 2022.3.24) - 3월 24일 입사일
//System.out.prtinln(s1) => [사번]a01 [이름]홍길동 [부서]COMPUTER [입사일]2022년3월24일(목)
public class Sawon {
	private String num; // 사번
	private String name; // 이름
	private String dept; // 부서
	private Date hiredate; //입사일
	
	public Sawon(String num, String name, String dept) {
		this.num = num;
		this.name = name;
		this.dept = dept;
		hiredate = new Date(); //입사일을 지금으로 설정하는 객체
	}
	public Sawon(String num, String name, String dept, int y, int m, int d) {
		this.num = num;
		this.name = name;
		this.dept = dept;
		//hiredate = new Date(y-1900, m-1, d); //입사일을 y년 m월 d일로.
		hiredate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	}
	@Override
	//System.out.prtinln(s1) => [사번]a01 [이름]홍길동 [부서]COMPUTER [입사일]2022년3월24일(목)
	//0. Tostring 오버라이드 1. SimpleDateFormat api, 2.String 함수(length())이용
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년M월d일(E)");
		if(dept.length()>10) {
			return "[사번]" + num +"\t[이름]" + name + "\t[부서]" + dept + "\t[입사일]" + sdf.format(hiredate);			
		}else
			return "[사번]" + num +"\t[이름]" + name + "\t[부서]" + dept + "\t\t[입사일]" + sdf.format(hiredate);			
	}
	
	
}
