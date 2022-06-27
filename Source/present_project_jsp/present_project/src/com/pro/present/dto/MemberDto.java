package com.pro.present.dto;

import java.sql.Date;

public class MemberDto {
	private String mid;
	private String mpw;
	private String mname;
	private Date mbirth;
	private String mgender;
	private int mbti;
	private Date mrdate;
	private int levelno;
	private int mlike;
	private int mwritecount;
	private String mbtiname;
	private String levelname;
	
	public MemberDto() {
	}
	
	public MemberDto(String mid, String mpw, String mname, Date mbirth, String mgender, int mbti, Date mrdate,
			int levelno, int mlike, int mwritecount) {
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mbirth = mbirth;
		this.mgender = mgender;
		this.mbti = mbti;
		this.mrdate = mrdate;
		this.levelno = levelno;
		this.mlike = mlike;
		this.mwritecount = mwritecount;
	}
	
	// 리스트 출력용
	public MemberDto(String mid, String mpw, String mname, Date mbirth, String mgender, int mbti, Date mrdate,
			int levelno, int mlike, int mwritecount, String mbtiname, String levelname) {
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mbirth = mbirth;
		this.mgender = mgender;
		this.mbti = mbti;
		this.mrdate = mrdate;
		this.levelno = levelno;
		this.mlike = mlike;
		this.mwritecount = mwritecount;
		this.mbtiname = mbtiname;
		this.levelname = levelname;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Date getMbirth() {
		return mbirth;
	}

	public void setMbirth(Date mbirth) {
		this.mbirth = mbirth;
	}

	public String getMgender() {
		return mgender;
	}

	public void setMgender(String mgender) {
		this.mgender = mgender;
	}

	public int getMbti() {
		return mbti;
	}

	public void setMbti(int mbti) {
		this.mbti = mbti;
	}

	public Date getMrdate() {
		return mrdate;
	}

	public void setMrdate(Date mrdate) {
		this.mrdate = mrdate;
	}

	public int getLevelno() {
		return levelno;
	}

	public void setLevelno(int levelno) {
		this.levelno = levelno;
	}

	public int getMlike() {
		return mlike;
	}

	public void setMlike(int mlike) {
		this.mlike = mlike;
	}

	public int getMwritecount() {
		return mwritecount;
	}

	public void setMwritecount(int mwritecount) {
		this.mwritecount = mwritecount;
	}

	public String getMbtiname() {
		return mbtiname;
	}

	public void setMbtiname(String mbtiname) {
		this.mbtiname = mbtiname;
	}

	public String getLevelname() {
		return levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	@Override
	public String toString() {
		return "MemberDto [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mbirth=" + mbirth + ", mgender="
				+ mgender + ", mbti=" + mbti + ", mrdate=" + mrdate + ", levelno=" + levelno + ", mlike=" + mlike
				+ ", mwritecount=" + mwritecount + ", mbtiname=" + mbtiname + ", levelname=" + levelname + "]";
	}
	
	
	
	
}
