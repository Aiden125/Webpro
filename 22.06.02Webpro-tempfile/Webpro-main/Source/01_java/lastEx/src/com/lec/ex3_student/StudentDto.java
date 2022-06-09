package com.lec.ex3_student;
// ����ϴ� ������ �Ǵ¾ֵ� ��� �ֱ�
// sexpel�� ��� ����� �� �ȳ����⿡ �ʿ�x
public class StudentDto {
	
	// �ʿ��� ������ ����
	private int rank;
	private String mname;
	private String sname;
	private String sno;
	private int score;
	//private int sexpel; �ʿ����
	
	// �Ű����� ���� ������ �����
	public StudentDto() { }
	
	// �й��˻���
	public StudentDto(String sno) {
		this.sno = sno;
	}
	
	

	public StudentDto(String mname,  String sname, int score, String sno) {
		this.mname = mname;
		this.sname = sname;
		this.sno = sno;
		this.score = score;
	}
	
	
	// �����˻���
	public StudentDto(int rank, String mname, String sname, int score) {
		super();
		this.rank = rank;
		this.mname = mname;
		this.sname = sname;
		this.score = score;
	}
	
	// �л� ������Ʈ��
	

	//�Է¿� : mname, sname, score, sexpel
	public StudentDto(String mname, String sname, int score) {
		this.mname = mname;
		this.sname = sname;
		this.score = score;
	}
	

	//��¿� :
	public StudentDto(int rank, String mname, String sname, int score, int sexpel) {
		super();
		this.rank = rank;
		this.mname = mname;
		this.sname = sname;
		this.score = score;
	}


	@Override
	public String toString() { // rank�� 0�϶��� �ƴ� ���� ������ �ϱ�
		if(rank!=0) {
			return rank+"��"+"\t"+sname+"\t"+mname+"\t"+score;
		}else {
			return sno+"\t"+sname+"\t"+mname+"\t"+score;
		}
//		return "���=" + rank + ", ����=" + mname + ", �̸�=" + sname + ", ����=" + score + ", ��������="
//				+ sexpel;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
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

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}


	
	
}
