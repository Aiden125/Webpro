package com.lec.ex2_person_dtoDao;
// Dto 만들기. 
// 너무 긴 자바 명령문을 줄여주기위한 java, db사이의 중간 다리 역할을 하는 클래스
public class PersonDto {
	
	// 필요한 데이터 정의
	private String rank;
	private String pname;
	private String jname;
	private int kor;
	private int eng;
	private int mat;
	private int sum;
	
	// 매개변수 없는 생성자 만들어 두기
	public PersonDto() { }
	
	// 입력용 : pname, jname, kor, eng, mat
	public PersonDto(String pname, String jname, int kor, int eng, int mat) {
		this.pname = pname;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	// 출력용 : rank, pname, jname, kor, eng, mat, sum
	public PersonDto(String rank, String pname, String jname, int kor, int eng, int mat, int sum) {
		super();
		this.rank = rank;
		this.pname = pname;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = sum;
	}
	
	// 프린트 원하는 형식 toString에 오버라이드
	@Override
	public String toString() {
		return rank + "등\t" + pname + (pname.length()<3?"\t":"\t") + jname + "\t" + kor + "\t" + eng
				+ "\t" + mat + "\t" + sum;
	}
	
	
	// getter&setter
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	} 
}
