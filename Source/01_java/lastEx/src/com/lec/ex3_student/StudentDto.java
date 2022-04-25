package com.lec.ex3_student;
// ����ϴ� ������ �Ǵ¾ֵ� ��� �ֱ�
// sexpel�� ��� ����� �� �ȳ����⿡ �ʿ�x
public class StudentDto {
	
	// �ʿ��� ������ ����
	private String rank;
	private String mname;
	private String sname;
	private String sno;
	private int score;
	// private int sexpel; �ʿ����
	
	// �Ű����� ���� ������ �����
	public StudentDto() { }
	
	// �й��˻���
	public StudentDto(String sno) {
		this.sno = sno;
	}



	public StudentDto( String sno, String sname,  String mname, int score) {
		this.mname = mname;
		this.sname = sname;
		this.sno = sno;
		this.score = score;
	}

	//�Է¿� : mname, sname, score, sexpel
	public StudentDto(String mname, String sname, int score, int sexpel) {
		this.mname = mname;
		this.sname = sname;
		this.score = score;
		this.sexpel = sexpel;
	}
	
	//��¿� :
	public StudentDto(String rank, String mname, String sname, int score, int sexpel) {
		super();
		this.rank = rank;
		this.mname = mname;
		this.sname = sname;
		this.score = score;
		this.sexpel = sexpel;
	}


	@Override
	public String toString() { // rank�� 0�϶��� �ƴ� ���� ������ �ϱ�
		if(rank!=0) {
			return
		}
//		return "���=" + rank + ", ����=" + mname + ", �̸�=" + sname + ", ����=" + score + ", ��������="
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
