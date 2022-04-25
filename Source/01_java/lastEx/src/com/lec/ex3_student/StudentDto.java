package com.lec.ex3_student;
// 출력하는 바탕이 되는애들 모두 넣기
// sexpel의 경우 출력할 때 안나오기에 필요x
public class StudentDto {
	
	// 필요한 데이터 정의
	private String rank;
	private String mname;
	private String sname;
	private String sno;
	private int score;
	// private int sexpel; 필요없음
	
	// 매개변수 없는 생성자 만들기
	public StudentDto() { }
	
	// 학번검색용
	public StudentDto(String sno) {
		this.sno = sno;
	}



	public StudentDto( String sno, String sname,  String mname, int score) {
		this.mname = mname;
		this.sname = sname;
		this.sno = sno;
		this.score = score;
	}

	//입력용 : mname, sname, score, sexpel
	public StudentDto(String mname, String sname, int score, int sexpel) {
		this.mname = mname;
		this.sname = sname;
		this.score = score;
		this.sexpel = sexpel;
	}
	
	//출력용 :
	public StudentDto(String rank, String mname, String sname, int score, int sexpel) {
		super();
		this.rank = rank;
		this.mname = mname;
		this.sname = sname;
		this.score = score;
		this.sexpel = sexpel;
	}


	@Override
	public String toString() { // rank가 0일때와 아닐 때를 나눠서 하기
		if(rank!=0) {
			return
		}
//		return "등수=" + rank + ", 전공=" + mname + ", 이름=" + sname + ", 점수=" + score + ", 제적여부="
//				+ sexpel;
	}


	public String getRank() {
		return rank;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getSexpel() {
		return sexpel;
	}


	public void setSexpel(int sexpel) {
		this.sexpel = sexpel;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	
	
}
